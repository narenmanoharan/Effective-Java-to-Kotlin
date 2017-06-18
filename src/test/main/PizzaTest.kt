package test

import main.Pizza
import main.PizzaMaker
import main.Toppings
import org.junit.Assert.*
import org.junit.Test

/**
 * Created by Naren on 6/15/17.
 */
class PizzaTest {

  val toppings: List<Toppings> = listOf(Toppings.Pineapple, Toppings.Chicken,
      Toppings.Onions, Toppings.BellPeppers, Toppings.Tomato)

  val pizza: Pizza = Pizza(12, toppings)

  val newPizzaMaker: PizzaMaker = PizzaMaker.Companion.getInstance(heat = 500, size = 20)

  @Test fun makePizza() {
    assertEquals("main.Pizza (Number = 12, main.Toppings = [Pineapple, Chicken, Onions, BellPeppers, Tomato])", pizza.makePizza())
  }

  @Test fun getNumber() {
    assertEquals(12 , pizza.number)
  }

  @Test fun getToppings() {
    assertEquals(toppings, pizza.toppings)
  }

  @Test fun getPizzaMaker() {
    assertEquals("main.PizzaMaker(heat=400, size=4)", pizza.pizzaMaker.toString())
  }

  @Test fun setPizzaMaker() {
    pizza.pizzaMaker = newPizzaMaker
    assertEquals("main.PizzaMaker(heat=500, size=20)", pizza.pizzaMaker.toString())
  }

  @Test fun getHeat() {
    assertEquals(500, newPizzaMaker.heat)
  }

  @Test fun getSize() {
    assertEquals(20, newPizzaMaker.size)
  }

  @Test fun testToString() {
    assertEquals("main.Pizza(Number=12, toppings=[Pineapple, Chicken, Onions, BellPeppers, Tomato])", pizza.toString())
  }

}