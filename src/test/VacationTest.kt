package test

import main.Mode.FLIGHT
import main.Vacation
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

/**
 * Created by Naren on 6/14/17.
 */
class VacationTest {

  var vacation : main.Vacation? = null

  @org.junit.Before fun setUp() {
      vacation = main.Vacation.Companion.build(mode = FLIGHT, cost = 10000) {
        destination = "SEYCHELLES"
        date = 20
        month = 9
        year = 2018
        duration = 2
      }
  }

  @org.junit.Test fun getDestination() {
    assertEquals("SEYCHELLES", vacation?.destination)
  }

  @org.junit.Test fun getDate() {
    assertEquals(20, vacation?.date)
  }

  @org.junit.Test fun getMonth() {
    assertEquals(9, vacation?.month)
  }

  @org.junit.Test fun getYear() {
    assertEquals(2018, vacation?.year)
  }

  @org.junit.Test fun getDuration() {
    assertEquals(2, vacation?.duration)
  }

  @org.junit.Test fun getMode() {
    assertEquals(main.Mode.FLIGHT, vacation?.mode)
  }

  @org.junit.Test fun getCost() {
    assertEquals(10000, vacation?.cost)
  }
}