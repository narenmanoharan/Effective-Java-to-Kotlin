import Brand.BMW
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by Naren on 6/14/17.
 */
class CarTest {

  val car : Car = Car.Companion.valueOf("M3", BMW, 260, 80, 160, 2, 14)

  @Test fun checkCarValue() {
    assertEquals("Car(model='M3', brand=BMW, maxSpeed=260, hp=80, torque=160, seating=2, mileage=14)", car.toString())
  }

}