import org.junit.Test

import com.google.common.truth.Truth.assertThat

/**
 * Created by Naren on 6/23/17.
 */
class TheNYTimesAPITest {

  @Test fun testKey() {
    assertThat(TheNYTimesAPI.API_KEY)
        .contains("bfa504d8afec47ba9757b3dab9201ddd")
  }
  @Test fun testUrl() {
    assertThat(TheNYTimesAPI.BASE_URL)
        .contains("https://api.nytimes.com/")
  }

  @Test fun testEndpoint() {
    assertThat(TheNYTimesAPI.API_ENDPOINT)
        .contains("/svc/search/v2/articlesearch.json")
  }

}