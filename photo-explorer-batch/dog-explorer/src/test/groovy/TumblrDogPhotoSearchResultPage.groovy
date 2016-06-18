import geb.Page

import util.UrlOutputUtil

/**
 * Created by Sa2 on 2016/06/05.
 */
//https://www.tumblr.com/search/dog
class TumblrDogPhotoSearchResultPage extends Page {
    def static theme = "dog"

    static url = "/search/${theme}"

    static at = { $('#posts').displayed }

    static content = {
        posts { $('#posts') }
        photos { $('img.photo') }

        // Controller
        scrollResults {
            def roopLimit = 5
            def scrollSpeed = 10000
            for (int i = 0; i < roopLimit; i++) {
                js.exec("window.scrollTo(${scrollSpeed * i}, ${scrollSpeed * (i+1)} );")
                Thread.sleep(5000)
            }
            return true
        }

        // Checker
        displayedPosts {
            waitFor {
                posts.displayed
            }
        }

        checkPostItemCount {
            def urlList = new ArrayList()
            waitFor {
                println(photos.size())
                photos.size() > 5
            }
            photos.each { photo ->
                if (photo.attr("src") ==~ /data:image.*/) {
                    urlList.add(photo.attr("data-src"))
                } else {
                    urlList.add(photo.attr("src"))
                }
            }
            UrlOutputUtil.outputUrlJson(urlList, theme)

            waitFor {
                photos.size() > 5
            }
        }
    }
}
