import org.junit.Test

import org.junit.Assert.*

import com.google.common.truth.Truth.assertThat

/**
 * Created by Naren on 6/23/17.
 */
class GhostTest {

  var ghost: GhostImpl = GhostImpl()

  @Test fun walk() {
    assertThat(ghost.walk())
        .contains("walking")
  }

  @Test fun swim() {
    assertThat(ghost.swim())
        .contains("swimming")
  }

  @Test fun crawl() {
    assertThat(ghost.crawl())
        .contains("crawling")
  }

  @Test fun scare() {
    assertThat(ghost.scare())
        .contains("Dark Clouds")
  }
}