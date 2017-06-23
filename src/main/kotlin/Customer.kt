/**
 * Created by Naren on 6/23/17.
 */

class Customer(val name: String, val fee: Double, private val discount: (Double) -> Double) {

  fun pricePerMonth(): Double {
    return discount(fee)
  }

}

// val studentDiscount = { fee: Double -> fee/2 }
// val noDiscount = { fee: Double -> fee }

// val regular = Customer("John", 100.0, noDiscount)
// val student = Customer("Ned", 150.0, studentDiscount)