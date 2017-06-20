package main

/**
 * Created by Naren on 6/17/17.
 */


data class Bear(private val name: String = "Fuzzy", private val age: Int = 0, val food: List<Food>)

enum class Food {
  Fish, Shrimp, Water
}
