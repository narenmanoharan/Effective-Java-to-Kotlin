package test

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Created by Naren on 6/16/17.
 */
class SheepTest {

  val sheep: main.Sheep = main.Sheep("Black", 10)

  val doggo: main.Doggo = main.Doggo("Golden", 2)

  val goodDoogo: main.Doggo = doggo.copy()

  @Test fun clone() {
    val evilSheep: main.Sheep = sheep.clone() as main.Sheep
    assertEquals(sheep.name, evilSheep.name)
    assertEquals(sheep.age, evilSheep.age)
  }

  @Test fun getName() {
    assertEquals("Golden", doggo.name)
  }

  @Test fun getAge() {
    assertEquals(2, doggo.age)
  }

  @Test fun copy() {
    assertEquals(goodDoogo, doggo)
  }

  @Test fun testToString() {
    assertEquals("Doggo(name=Golden, age=2)", doggo.toString())
  }

  @Test fun testHashCode() {
    assertEquals(1868907513, doggo.hashCode())
  }

  @Test fun equals() {
    assertTrue(doggo == goodDoogo)
    assertTrue(doggo !== goodDoogo)
    assertTrue(doggo.javaClass == goodDoogo.javaClass)
  }
}