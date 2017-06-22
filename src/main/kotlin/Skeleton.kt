/**
 * Created by Naren on 6/23/17.
 */

interface Skeleton {

  fun walk(): String {
    return "Slow walk"
  }

  fun swim(): String {
    return "Slow swim"
  }

  fun crawl(): String {
    return "Slow crawl"
  }

  fun scare(): String {
    return "Slow scare"
  }

}

abstract class AbstractGhost : Skeleton {

  override fun walk(): String {
    return "Slowly walking..."
  }

  override fun swim(): String {
    return "Rapidly swimming"
  }

  override fun crawl(): String {
    return "Creepily crawling"
  }
}

class GhostImpl : AbstractGhost() {

  override fun scare(): String {
    return this.darkClouds()
  }

  private fun darkClouds(): String {
    return "Ominous Dark Clouds...."
  }

}