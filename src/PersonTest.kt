import org.junit.Test

import org.junit.Assert.*

/**
 * Created by Naren on 6/16/17.
 */
class PersonTest {

  val naren: Person = Person("Narendra Kumar", "Manoharan", 23, 183)

  var evilTwin: Person = naren.copy()


  @Test fun getFName() {
    assertEquals("Narendra Kumar", naren.fName)
  }

  @Test fun getLName() {
    assertEquals("Manoharan", naren.lName)
  }

  @Test fun getAge() {
    assertEquals(23, naren.age)
  }

  @Test fun setAge() {
    naren.age = 24
    assertEquals(24, naren.age)
  }

  @Test fun getHeight() {
    assertEquals(183, naren.height)
  }

  @Test fun setHeight() {
    naren.height = 185
    assertEquals(185, naren.height)
  }

  @Test fun copy() {
    assertEquals(naren.hashCode(), evilTwin.hashCode())
  }

  @Test fun testToString() {
    assertEquals("Person(fName=Narendra Kumar, lName=Manoharan, age=23, height=183)", naren.toString())
  }

  @Test fun testHashCode() {
    assertEquals(naren.hashCode(), evilTwin.hashCode())
  }

  @Test fun testEquals() {
    assertTrue(naren == evilTwin)
  }

  @Test fun testNotTheSame() {
    assertFalse(naren === evilTwin)
  }
}