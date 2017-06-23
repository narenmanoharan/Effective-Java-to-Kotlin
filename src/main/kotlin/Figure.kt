/**
 * Created by Naren on 6/23/17.
 */


abstract class Figure {
  abstract fun area(): Double
}

class Circle(val radius: Int) : Figure() {

  override fun area(): Double {
    return Math.PI * (radius * radius)
  }

}

open class Rectangle(val length: Int, val width: Int) : Figure() {

  override fun area(): Double {
    return (length * width).toDouble()
  }

}

class Square(val side: Int) : Rectangle(side, side) {

  override fun area(): Double {
    return (side * side).toDouble()
  }

}