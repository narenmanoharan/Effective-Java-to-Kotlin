import Toppings.BellPeppers
import Toppings.Chicken
import Toppings.Onions
import Toppings.Pineapple
import Toppings.Tomato
import org.junit.Assert.*
import org.junit.Test

/**
 * Created by Naren on 6/15/17.
 */
class PizzaTest {

  val toppings: List<Toppings> = listOf(Pineapple, Chicken, Onions, BellPeppers, Tomato)

  val pizza: Pizza = Pizza(12, toppings)

  val newPizzaMaker: PizzaMaker = PizzaMaker.getInstance(heat = 500, size = 20)

  @Test fun makePizza() {
    assertEquals("Pizza (Number = 12, Toppings = [Pineapple, Chicken, Onions, BellPeppers, Tomato])", pizza.makePizza())
  }

  @Test fun getNumber() {
    assertEquals(12 , pizza.number)
  }

  @Test fun getToppings() {
    assertEquals(toppings, pizza.toppings)
  }

  @Test fun getPizzaMaker() {
    assertEquals("PizzaMaker(heat=400, size=4)", pizza.pizzaMaker.toString())
  }

  @Test fun setPizzaMaker() {
    pizza.pizzaMaker = newPizzaMaker
    assertEquals("PizzaMaker(heat=500, size=20)", pizza.pizzaMaker.toString())
  }

  @Test fun getHeat() {
    assertEquals(500, newPizzaMaker.heat)
  }

  @Test fun getSize() {
    assertEquals(20, newPizzaMaker.size)
  }
}