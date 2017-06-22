import Position.CFO
import org.junit.Test

import com.google.common.truth.Truth.assertThat

import java.math.BigInteger

/**
 * Created by Naren on 6/21/17.
 */
class JobTest {

  val jobCFO : Job = Job(CFO, BigInteger.valueOf(400000), 1000)

  @Test fun getPosition() {
    assertThat(jobCFO.position)
        .isEqualTo(CFO)
  }

  @Test fun getSalary() {
    assertThat(jobCFO.salary)
        .isEqualTo(BigInteger.valueOf(400000))
  }

  @Test fun getId() {
    assertThat(jobCFO.id)
        .isEqualTo(1000)
  }

  @Test fun testToString() {
    assertThat(jobCFO.toString())
        .isEqualTo("Job(position=CFO, salary=400000, id=1000)")
  }

  @Test fun equals() {
    val copyJob: Job = jobCFO.copy()
    assertThat(copyJob)
        .isEqualTo(jobCFO)
  }
}