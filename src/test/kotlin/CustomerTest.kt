import org.junit.Test

import com.google.common.truth.Truth.assertThat

/**
 * Created by Naren on 6/23/17.
 */
class CustomerTest {

  val studentDiscount = { fee: Double -> fee/2 }
  val noDiscount = { fee: Double -> fee }

  val regular = Customer("John", 100.0, noDiscount)
  val student = Customer("Ned", 150.0, studentDiscount)

  @Test fun pricePerMonth() {
    assertThat(student.pricePerMonth())
        .isEqualTo(75.0)
  }

  @Test fun getName() {
    assertThat(regular.name)
        .contains("John")
  }

  @Test fun getFee() {
    assertThat(student.fee)
        .isEqualTo(150.0)
  }
}