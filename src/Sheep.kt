/**
 * Created by Naren on 6/16/17.
 */

// Using the cloneable interface (Java way)
class Sheep(val name: String, val age: Int) : Cloneable {

  @Throws(CloneNotSupportedException::class)
  public override fun clone(): Any {
    return super.clone() as Sheep
  }

}

// Using the data class with copy (Kotlin way)

data class Doggo(val name: String, val age: Int)