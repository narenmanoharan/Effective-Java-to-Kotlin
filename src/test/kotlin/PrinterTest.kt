import org.junit.Test

import org.junit.Assert.*

import com.google.common.truth.Truth.assertThat

/**
 * Created by Naren on 6/23/17.
 */
class PrinterTest {

  val lowerCaseFormatter: (String) -> String = { it.toLowerCase() }

  val upperCaseFormatter = { it: String -> it.toUpperCase() }

  val lowerCasePrinter: Printer = Printer(lowerCaseFormatter)

  val upperCasePrinter: Printer = Printer(upperCaseFormatter)

  val inputString: String = "Hello World!!"


  @Test fun printUpperString() {
    assertThat(upperCasePrinter.printString(inputString))
        .isEqualTo("HELLO WORLD!!")
  }

  @Test fun printLowerString() {
    assertThat(lowerCasePrinter.printString(inputString))
        .isEqualTo("hello world!!")
  }

}