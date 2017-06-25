import Static.Inner
import com.google.common.truth.Truth.assertThat
import org.junit.Test

/**
 * Created by Naren on 6/24/17.
 */
class StaticTest {

  val static: Static = Static()
  val staticInner: Inner = Static.Inner()

  val nonStatic: NonStatic = NonStatic()
  val inner: NonStatic.Inner = nonStatic.Inner()

  val local: Local = Local()

  @Test fun testStatic() {

    assertThat(static.toString())
        .contains("Static@")

    assertThat(staticInner.reference())
        .contains("Inner Class ref Static\$Inner@")
  }

  @Test fun testNonStaticOuterVal() {
    assertThat(inner.getOuterVal())
        .isEqualTo(100)
  }

  @Test fun testNonStaticInnerRef() {
    assertThat(inner.getInnerRef())
        .contains("Inner class reference is NonStatic\$Inner@")
  }

  @Test fun testNonStaticOuterRef() {
    assertThat(inner.getOuterRef())
        .contains("@NonStatic")
  }

  @Test fun testLocal() {
    assertThat(local.doStuff())
        .contains("x is local outer")
  }

  @Test fun testStaticLocal() {
    assertThat(StaticLocal.doStuff())
        .contains("x is static local outer")
  }

}