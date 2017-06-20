package main

/**
 * Created by Naren on 6/15/17.
 */

// Private constructor
class Burger private constructor(val size: Int,
                                 val cheese: Boolean?,
                                 val pepperoni: Boolean?,
                                 val pineapple: Boolean?) {

  companion object {
    fun valueOf(size: Int, cheese: Boolean?, pepperoni: Boolean?, pineapple: Boolean?): main.Burger {
      return main.Burger(size, cheese, pepperoni, pineapple)
    }
  }

  override fun toString(): String {
    return "main.Burger(size=$size, cheese=$cheese, pepperoni=$pepperoni, pineapple=$pineapple)"
  }
}