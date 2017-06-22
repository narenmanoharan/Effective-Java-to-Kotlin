/**
 * Created by Naren on 6/21/17.
 */


class Complex(private val real: Double, private val imaginary: Double) {

  internal fun realValue() : Double {
    return this.real
  }

  internal fun imaginaryValue() : Double {
    return this.imaginary
  }

  internal fun add(c: Complex): Complex {
    return Complex(real + c.real, imaginary + c.imaginary)
  }

  internal fun subtract(c: Complex): Complex {
    return Complex(real - c.real, imaginary - c.imaginary)
  }

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (other?.javaClass != javaClass) return false

    other as Complex

    if (real != other.real) return false
    if (imaginary != other.imaginary) return false

    return true
  }

  override fun hashCode(): Int {
    var result = real.hashCode()
    result = 31 * result + imaginary.hashCode()
    return result
  }

  override fun toString(): String {
    return "Complex(real=$real, imaginary=$imaginary)"
  }

}