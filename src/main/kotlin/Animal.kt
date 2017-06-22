/**
 * Created by Naren on 6/22/17.
 */


open class Animal(val genus: String, val species: String, var mutation: Boolean) {

  open fun isPet(): Boolean {
    return false
  }

  open val sleep: String
    get() {
      return "Sleeping..."
    }

}

class Dog : Animal("Canis", "familiaris", false) {

  override fun isPet(): Boolean {
    return true
  }

  override val sleep: String
    get() {
      return "Snoozing..."
    }
}