import Mode.FLIGHT
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

/**
 * Created by Naren on 6/14/17.
 */
class VacationTest {

  var vacation : Vacation? = null

  @Before fun setUp() {
    vacation = Vacation.build(mode = FLIGHT, cost = 10000) {
      destination = "SEYCHELLES"
      date = 20
      month = 9
      year = 2018
      duration = 2
    }
  }

  @Test fun getDestination() {
    assertEquals("SEYCHELLES", vacation?.destination)
  }

  @Test fun getDate() {
    assertEquals(20, vacation?.date)
  }

  @Test fun getMonth() {
    assertEquals(9, vacation?.month)
  }

  @Test fun getYear() {
    assertEquals(2018, vacation?.year)
  }

  @Test fun getDuration() {
    assertEquals(2, vacation?.duration)
  }

  @Test fun getMode() {
    assertEquals(FLIGHT, vacation?.mode)
  }

  @Test fun getCost() {
    assertEquals(10000, vacation?.cost)
  }
}