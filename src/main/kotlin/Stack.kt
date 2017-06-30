import java.util.Arrays
import java.util.EmptyStackException

/**
 * Created by Naren on 6/26/17.
 */


class Stack(var elements: Array<Any>?, private var size: Int = 0, private val capacity: Int = 16) {

  fun push(e: Any) {
    ensureCapacity()
    elements?.set(size++, e)
  }

  fun pop(): Any {
    if (size == 0)
      throw EmptyStackException()
    val result: Any = elements!![--size]
    return result
  }

  fun isEmpty(): Boolean {
    return size == 0
  }

  fun size() : Int {
    return size
  }

  private fun ensureCapacity() {
    if (elements?.size == size)
      elements = Arrays.copyOf(elements!!, 2 * size + 1)
  }

  override fun toString(): String {
    return "Stack(elements=${Arrays.toString(elements)}, size=$size, capacity=$capacity)"
  }
}