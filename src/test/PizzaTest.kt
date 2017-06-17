package test

import org.junit.Assert.*

/**
 * Created by Naren on 6/15/17.
 */
class PizzaTest {

  val toppings: List<main.Toppings> = listOf(main.Toppings.Pineapple, main.Toppings.Chicken,
      main.Toppings.Onions, main.Toppings.BellPeppers, main.Toppings.Tomato)

  val pizza: main.Pizza = main.Pizza(12, toppings)

  val newPizzaMaker: main.PizzaMaker = main.PizzaMaker.Companion.getInstance(heat = 500, size = 20)

  @org.junit.Test fun makePizza() {
    assertEquals("main.Pizza (Number = 12, main.Toppings = [Pineapple, Chicken, Onions, BellPeppers, Tomato])", pizza.makePizza())
  }

  @org.junit.Test fun getNumber() {
    assertEquals(12 , pizza.number)
  }

  @org.junit.Test fun getToppings() {
    assertEquals(toppings, pizza.toppings)
  }

  @org.junit.Test fun getPizzaMaker() {
    assertEquals("main.PizzaMaker(heat=400, size=4)", pizza.pizzaMaker.toString())
  }

  @org.junit.Test fun setPizzaMaker() {
    pizza.pizzaMaker = newPizzaMaker
    assertEquals("main.PizzaMaker(heat=500, size=20)", pizza.pizzaMaker.toString())
  }

  @org.junit.Test fun getHeat() {
    assertEquals(500, newPizzaMaker.heat)
  }

  @org.junit.Test fun getSize() {
    assertEquals(20, newPizzaMaker.size)
  }
}