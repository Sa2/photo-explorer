import geb.spock.GebReportingSpec

/**
 * Created by Sa2 on 2016/06/05.
 */
class DogSearchSpec extends GebReportingSpec {

    def "search dog pics on tumblr"() {
        when:
        to TumblrDogPhotoSearchResultPage

        then:
        displayedPosts

        when:
        scrollResults()

        then:
        checkPostItemCount

    }
}
