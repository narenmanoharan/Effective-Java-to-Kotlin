import org.junit.Test

import com.google.common.truth.Truth.assertThat

/**
 * Created by Naren on 6/23/17.
 */
class FigureTest {

  val circle: Circle = Circle(5)

  val rect: Rectangle = Rectangle(5, 10)

  val square: Square = Square(5)

  @Test fun testSquareArea() {
    assertThat(square.area())
        .isEqualTo(25.0)
  }

  @Test fun testRectArea() {
    assertThat(rect.area())
        .isEqualTo(50.0)
  }

  @Test fun testCircleArea() {
    assertThat(circle.area())
        .isEqualTo(78.53981633974483)
  }
}