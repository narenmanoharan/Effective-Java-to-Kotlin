package main

/**
 * Created by Naren on 6/16/17.
 */

// Using the cloneable interface (Java way)
class Sheep(val name: String, val age: Int) : Cloneable {

  @Throws(CloneNotSupportedException::class)
  public override fun clone(): Any {
    return super.clone() as main.Sheep
  }

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (other?.javaClass != javaClass) return false

    other as Sheep

    if (name != other.name) return false
    if (age != other.age) return false

    return true
  }

  override fun hashCode(): Int {
    var result = name.hashCode()
    result = 31 * result + age
    return result
  }


}

// Using the data class with copy (Kotlin way)

data class Doggo(val name: String, val age: Int)