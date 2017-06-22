import org.junit.Test

import com.google.common.truth.Truth.assertThat

/**
 * Created by Naren on 6/22/17.
 */
class AnimalTest {

  val animal: Animal = Animal("Panthera", "Felidae", false)

  val dog: Dog = Dog()

  @Test fun isPet() {
    assertThat(animal.isPet())
        .isFalse()
  }

  @Test fun getSleep() {
    assertThat(animal.sleep)
        .contains("Sleeping")
  }

  @Test fun getGenus() {
    assertThat(animal.genus)
        .contains("Panthera")
  }

  @Test fun getSpecies() {
    assertThat(animal.species)
        .contains("Felidae")
  }

  @Test fun getMutation() {
    assertThat(animal.mutation)
        .isFalse()
  }

  @Test fun setMutation() {
    animal.mutation = true

    assertThat(animal.mutation)
        .isTrue()
  }

  @Test fun dogIsPet() {
    assertThat(dog.isPet())
        .isTrue()
  }

  @Test fun dogGetSleep() {
    assertThat(dog.sleep)
        .contains("Snoozing")
  }

  @Test fun dogGetGenus() {
    assertThat(dog.genus)
        .contains("Canis")
  }

  @Test fun dogGetSpecies() {
    assertThat(dog.species)
        .contains("familiaris")
  }

  @Test fun dogGetMutation() {
    assertThat(dog.mutation)
        .isFalse()
  }

  @Test fun dogSetMutation() {
    dog.mutation = true

    assertThat(dog.mutation)
        .isTrue()
  }
}