/**
 * Created by Naren on 6/24/17.
 */

// Static member classes

class Static {
  class Inner {
    fun reference(): String {
      return "Inner Class ref $this"
    }
  }
}


// Non-static member classes

class NonStatic {

  private val x = 100

  inner class Inner {

    fun getOuterVal(): Int {
      return x
    }

    fun getInnerRef(): String {
      return "Inner class reference is $this"
    }

    fun getOuterRef(): String {
      return "Outer class reference is $this@NonStatic"
    }
  }
}

// Local classes

class Local {

  private val x = "local outer"

  fun doStuff(): String {
    class MyInner {
      fun seeOuter(): String {
        return "x is $x"
      }
    }

    val i = MyInner()
    return i.seeOuter()
  }
}


// Static Local classes

object StaticLocal {

  private val x = "static local outer"

  fun doStuff() : String {
    class MyInner {
      fun seeOuter(): String {
        return "x is $x"
      }
    }

    val i = MyInner()
    return i.seeOuter()
  }
}


