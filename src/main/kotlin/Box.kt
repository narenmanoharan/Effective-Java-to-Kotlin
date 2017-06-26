/**
 * Created by Naren on 6/26/17.
 */

class Box<T>(private val name: String, private val items: List<T>) {

  fun getItems(): List<T> {
    return items
  }

  fun getName(): String {
    return name
  }
  
}

class BoxOut<out T>(private val name: String, private val items: List<T>) {

  fun getItems(): List<T> {
    return items
  }

  fun getName(): String {
    return name
  }

}

class BoxIn<in T> {

  fun toString(value: T): String {
    return value.toString()
  }
}

enum class Books {
  Java, Kotlin, Android, Testing, Mockito, JUnit
}