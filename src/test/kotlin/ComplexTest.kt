import org.junit.Test

import com.google.common.truth.Truth.assertThat

/**
 * Created by Naren on 6/21/17.
 */

class ComplexTest {

  private val int: Int = 20
  private val complex: Complex = Complex(10.0, 20.0)
  private val newComplex: Complex = Complex(5.0, 2.0)
  private val resultAdd: Complex = complex.add(newComplex)
  private val expectedAdd: Complex = Complex(15.0, 22.0)
  private val resultSub: Complex = complex.subtract(newComplex)
  private val expectedSub: Complex = Complex(5.0, 18.0)

  @Test fun testGetRealValue() {
    assertThat(complex.realValue())
        .isEqualTo(10.0)
  }

  @Test fun testImaginaryRealValue() {
    assertThat(complex.imaginaryValue())
        .isEqualTo(20.0)
  }

  @Test fun testAddComplex() {
    assertThat(resultAdd).isEqualTo(expectedAdd)
  }

  @Test fun testSubComplex() {
    assertThat(resultSub).isEqualTo(expectedSub)
  }

  @Test fun testEquals() {

    val deepCopy: Complex = Complex(10.0, 20.0)

    assertThat(deepCopy).isEqualTo(complex)
  }

  @Test fun testRealNotEquals() {
    val newComplex: Complex = Complex(1.0, 20.0)
    assertThat(newComplex).isNotEqualTo(complex)
  }

  @Test fun testImaginaryNotEquals() {
    val newComplex: Complex = Complex(10.0, 5.0)
    assertThat(newComplex).isNotEqualTo(complex)
  }

  @Test fun testReferentialEquality() {
    assertThat(complex)
        .isEqualTo(complex)
  }

  @Test fun testClassEquals() {
    assertThat(complex)
        .isNotEqualTo(int)
  }

  @Test fun testHashCode() {
    assertThat(complex.hashCode())
        .isEqualTo(76546048)
  }

  @Test fun testToString() {
    assertThat(complex.toString())
        .isEqualTo("Complex(real=10.0, imaginary=20.0)")
  }
}
