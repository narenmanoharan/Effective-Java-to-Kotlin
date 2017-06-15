import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by Naren on 6/15/17.
 */
class BurgerTest {

//  val burger: Burger = Burger(10)  Does not work

  val burger: Burger = Burger.valueOf(10, cheese = true, pepperoni = true, pineapple = true)

  g@Test fun checkBurgerValue() {
    assertEquals("Burger(size=10, cheese=true, pepperoni=true, pineapple=true)", burger.toString())
  }

  @Test fun checkSizeValue() {
    assertEquals(10, burger.size)
  }

  @Test fun checkCheeseValue() {
    assertEquals(true, burger.cheese)
  }

  @Test fun checkPepperoniValue() {
    assertEquals(true, burger.pepperoni)
  }

  @Test fun checkPineappleValue() {
    assertEquals(true, burger.pineapple)
  }

}