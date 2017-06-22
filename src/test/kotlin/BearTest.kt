import Food.Fish
import Food.Shrimp
import org.junit.Assert.assertEquals
import org.junit.Test


/**
 * Created by Naren on 6/17/17.
 */
class BearTest {

  val bear: Bear = Bear(age = 2 , food = listOf(Fish, Shrimp))

  @Test fun getFood() {
    assertEquals(listOf(Fish, Shrimp), bear.food)
  }

  @Test fun copy() {
    val kidBear: Bear = bear.copy()
    assertEquals(kidBear, bear)
  }
}