import Books.Android
import Books.Java
import Books.Kotlin
import Books.Testing
import org.junit.Test

import com.google.common.truth.Truth.assertThat

/**
 * Created by Naren on 6/26/17.
 */
class BoxTest {

  val boxOfBooks: Box<Books> = Box("Book box", listOf(Java, Kotlin))
  val boxOutOfBooks: BoxOut<Books> = BoxOut("Book out box", listOf(Android, Testing))
  val boxInOfBooks: BoxIn<Books> = BoxIn()

  @Test fun getItems() {
    assertThat(boxOfBooks.getItems())
        .isEqualTo(listOf(Java, Kotlin))
  }

  @Test fun getName() {
    assertThat(boxOfBooks.getName())
        .contains("Book box")
  }

  @Test fun getBoxItems() {
    assertThat(boxOutOfBooks.getItems())
        .isEqualTo(listOf(Android, Testing))
  }

  @Test fun getBoxName() {
    assertThat(boxOutOfBooks.getName())
        .contains("Book out box")
  }

  @Test fun getToString() {
    assertThat(boxInOfBooks.toString(Android))
        .contains("Android")
  }
}