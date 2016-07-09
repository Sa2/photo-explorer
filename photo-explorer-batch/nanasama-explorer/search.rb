require 'uri'
require 'json'
require 'pry'
require 'open-uri'
require 'openssl'
require 'date'


# ID/PASSを環境変数から取得
# username = URI.escape(ENV['BING_SEARCH_USERNAME'])
# password = URI.escape(ENV['BING_SEARCH_ACCOUNT_KEY'])
username = ENV['BING_SEARCH_USERNAME']
password = ENV['BING_SEARCH_ACCOUNT_KEY']
query = '\'水樹奈々\''

params = { Query: query, Market: '\'ja-JP\'', Adult: '\'Strict\'', ImageFilters: '\'Size:Large\'', '$format': 'json' }

# URI
# URI.parseは与えられたURIからURI::Genericのサブクラスのインスタンスを返す
uri = URI.parse("https://api.datamarket.azure.com/Bing/Search/v1/Image")
uri.query = URI.encode_www_form(params)

# Bingで検索
begin
  json = open(uri,
    { http_basic_authentication: [username, password],
     ssl_verify_mode: OpenSSL::SSL::VERIFY_NONE }).read
rescue => e
  p e
end

# 検索結果をハッシュにparse
result = JSON.parse(json)

# 検索結果の一覧を抽出
result_list = result['d']['results'].map do |value|
  value["MediaUrl"]
end

media_url = { mediaUrl: result_list }

pp media_url

output_dir = '../../data-warehouse/json/'

json_file = output_dir + 'nanasama-urls.json'

open(json_file, 'w') do |output|
  JSON.dump(media_url, output)
end
