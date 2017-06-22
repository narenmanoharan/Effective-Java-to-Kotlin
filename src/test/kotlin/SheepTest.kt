import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

import com.google.common.truth.Truth.assertThat

/**
 * Created by Naren on 6/16/17.
 */
class SheepTest {

  val sheep: Sheep = Sheep("Black", 10)

  val doggo: Doggo = Doggo("Golden", 2)

  val goodDoggo: Doggo = doggo.copy()

  @Test fun clone() {
    val evilSheep: Sheep = sheep.clone() as Sheep
    assertEquals(sheep.name, evilSheep.name)
    assertEquals(sheep.age, evilSheep.age)
  }

  @Test fun getSheepName() {
    assertThat(sheep.name)
        .isEqualTo("Black")
  }

  @Test fun getSheepAge() {
    assertThat(sheep.age)
        .isEqualTo(10)
  }

  @Test fun getName() {
    assertEquals("Golden", doggo.name)
  }

  @Test fun getAge() {
    assertEquals(2, doggo.age)
  }

  @Test fun copy() {
    assertEquals(goodDoggo, doggo)
  }

  @Test fun testToString() {
    assertEquals("Doggo(name=Golden, age=2)", doggo.toString())
  }

  @Test fun testHashCode() {
    assertEquals(1868907513, doggo.hashCode())
  }

  @Test fun equals() {
    assertTrue(doggo == goodDoggo)
    assertTrue(doggo !== goodDoggo)
    assertTrue(doggo.javaClass == goodDoggo.javaClass)
  }
}