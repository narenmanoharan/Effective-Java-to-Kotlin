/**
 * Created by Naren on 6/14/17.
 */

// Static Factory Methods
class Car

private constructor(private val model: String,
    private val brand: Brand,
    private val maxSpeed: Int? ,
    private val hp: Int?,
    private val torque: Int?,
    private val seating: Int?,
    private val mileage: Int?) {

  companion object {

    fun valueOf(model: String,
                brand: Brand,
                maxSpeed: Int?,
                hp: Int?,
                torque: Int?,
                seating: Int?,
                mileage: Int?): Car {
      return Car(model, brand, maxSpeed, hp, torque, seating, mileage)
    }
  }

  override fun toString(): String {
    return "Car(model='$model', brand=$brand, maxSpeed=$maxSpeed, hp=$hp, torque=$torque, seating=$seating, mileage=$mileage)"
  }
}

enum class Brand {
  BMW, Lamborghini, Porsche, Audi, Lotus
}