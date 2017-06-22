import Units.cm
import Units.m
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

/**
 * Created by Naren on 6/19/17.
 */
class HeightConverterTest {

  var converter: HeightConverter? = null

  @Before fun setUp() {
    converter = HeightConverter()
    converter?.value = 200
    converter?.from = cm
    converter?.to = m
  }

  @Test fun setValue() {
    converter?.value = 200
    assertEquals(200, converter?.value)
  }

  @Test fun getValue() {
    assertEquals(200, converter?.value)
  }

  @Test fun setFrom() {
    converter?.from = m
    assertEquals(m, converter?.from)
  }

  @Test fun getFrom() {
    assertEquals(cm, converter?.from)
  }

  @Test fun setTo() {
    converter?.to = cm
    assertEquals(cm, converter?.to)
  }

  @Test fun getTo() {
    assertEquals(m, converter?.to)
  }

  @Test fun getNewValue() {
    assertEquals(100, converter?.newValue)
  }


}