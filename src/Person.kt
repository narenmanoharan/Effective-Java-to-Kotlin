/**
 * Created by Naren on 6/16/17.
 */


data class Person(val fName: String, val lName: String, var age: Int?, var height: Int?)


class hello(val fName: String, val lName: String, var age: Int?) {

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (other?.javaClass != javaClass) return false

    other as hello

    if (fName != other.fName) return false
    if (lName != other.lName) return false
    if (age != other.age) return false

    return true
  }

  override fun hashCode(): Int {
    var result = fName.hashCode()
    result = 31 * result + lName.hashCode()
    result = 31 * result + (age ?: 0)
    return result

  }
}