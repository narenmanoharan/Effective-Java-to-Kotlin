import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

/**
 * Created by Naren on 6/26/17.
 */
class StackTest {

  val stack: Stack = Stack(emptyArray())

  @Before fun setUp() {
    stack.push(10)
  }

  @Test fun push() {
    assertThat(stack.toString())
        .contains("Stack(elements=[10], size=1")
  }

  @Test fun pop() {
    assertThat(stack.pop())
        .isEqualTo(10)
  }

  @Test fun isEmpty() {
    assertThat(stack.isEmpty())
        .isFalse()
  }

  @Test fun getElements() {
    stack.push(10)
    stack.push(20)
    assertThat(stack.elements)
        .asList()
        .containsAllOf(10,20)
  }

  @Test fun setElements() {
    stack.elements = arrayOf(10, 20)
    assertThat(stack.elements)
        .asList()
        .containsAllOf(10,20)
  }

  @Test fun testToString() {
    assertThat(stack.toString())
        .contains("Stack(elements=[10], size=1, capacity=16)")
  }

}