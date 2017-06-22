import org.junit.Test
import com.google.common.truth.Truth.assertThat
import java.math.BigInteger

/**
 * Created by Naren on 6/22/17.
 */
class CEOTest {

  private val ceo: CEO = CEO("Di Caprio")

  @Test fun getName() {
    assertThat(ceo.name)
        .isEqualTo(ceo.name)
  }

  @Test fun getSalary() {
    assertThat(ceo.getSalary())
        .isEqualTo(BigInteger.valueOf(500000))
  }

  @Test fun getJobId() {
    assertThat(ceo.getJobId())
        .isEqualTo(1000)
  }

}