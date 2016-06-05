package util

import groovy.json.JsonBuilder
import groovy.json.StringEscapeUtils

/**
 * Created by Sa2 on 2016/06/05.
 */
class UrlOutputUtil {

    def static outputUrlJson(ArrayList<String> urls, String title) {
        new File("../data-warehouse/json/${title}-urls.json").withWriter("UTF-8") { writer ->

            def json = new JsonBuilder()

            json (
                "mediaUrl" : urls
            )

            writer.write(StringEscapeUtils.unescapeJavaScript(json.toString()))

        }
    }
}
