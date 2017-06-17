package test

import main.Person
import org.junit.Test

import org.junit.Assert.*

/**
 * Created by Naren on 6/16/17.
 */
class PersonTest {

  val naren: main.Person = main.Person("Narendra Kumar", "Manoharan", 23, 183)

  var evilTwin: main.Person = naren.copy()


  @org.junit.Test fun getFName() {
    assertEquals("Narendra Kumar", naren.fName)
  }

  @org.junit.Test fun getLName() {
    assertEquals("Manoharan", naren.lName)
  }

  @org.junit.Test fun getAge() {
    assertEquals(23, naren.age)
  }

  @org.junit.Test fun setAge() {
    naren.age = 24
    assertEquals(24, naren.age)
  }

  @org.junit.Test fun getHeight() {
    assertEquals(183, naren.height)
  }

  @org.junit.Test fun setHeight() {
    naren.height = 185
    assertEquals(185, naren.height)
  }

  @org.junit.Test fun copy() {
    assertEquals(naren.hashCode(), evilTwin.hashCode())
  }

  @org.junit.Test fun testToString() {
    assertEquals("Person(fName=Narendra Kumar, lName=Manoharan, age=23, height=183)", naren.toString())
  }

  @org.junit.Test fun testHashCode() {
    assertEquals(naren.hashCode(), evilTwin.hashCode())
  }

  @org.junit.Test fun testEquals() {
    assertTrue(naren == evilTwin)
  }

  @org.junit.Test fun testNotTheSame() {
    assertFalse(naren === evilTwin)
  }
}