/**
 * Created by Naren on 6/23/17.
 */


class Printer(private val formatterStrategy: (String) -> String) {

  fun printString(string: String): String {
    return formatterStrategy(string)
  }

}

