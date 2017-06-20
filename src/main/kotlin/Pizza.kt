package main

/**
 * Created by Naren on 6/15/17.
 */

class Pizza(val number: Int, val toppings: List<main.Toppings>) {

  var pizzaMaker: main.PizzaMaker? = null

  init {
    pizzaMaker = main.PizzaMaker.Companion.getInstance(heat = 400, size = 4)
  }

  fun makePizza() : String? {
    val pizza : String? = pizzaMaker?.makePizza(number = number, toppings = toppings)
    return pizza
  }

  override fun toString(): String {
    return "main.Pizza(Number=$number, toppings=$toppings)"
  }

}

class PizzaMaker private constructor(val heat: Int, val size: Int?) {

  companion object {
    fun getInstance(heat: Int, size: Int?): main.PizzaMaker {
      return main.PizzaMaker(heat, size)
    }
  }

  fun makePizza(number: Int, toppings: List<main.Toppings>): String {
    return "main.Pizza (Number = $number, main.Toppings = $toppings)"
  }

  override fun toString(): String {
    return "main.PizzaMaker(heat=$heat, size=$size)"
  }

}

  enum class Toppings {
  Pineapple, Pepperoni, Chicken, Olives, Mushroom, Tomato, BellPeppers, Onions, Cheese
}
