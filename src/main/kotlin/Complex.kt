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

}