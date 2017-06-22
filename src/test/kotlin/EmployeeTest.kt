import Position.CEO
import Position.CFO
import org.junit.Test

import java.math.BigInteger

import com.google.common.truth.Truth.assertThat

/**
 * Created by Naren on 6/22/17.
 */
class EmployeeTest {

  val jobCFO: Job = Job(CFO, BigInteger.valueOf(400000), 1000)

  val emp: Employee = Employee("Leonardo", jobCFO)

  @Test fun setJob() {
    val jobCEO: Job = Job(CEO, BigInteger.valueOf(500000), 1001)
    emp.job = jobCEO
    assertThat(emp.job)
        .isEqualTo(jobCEO)
  }

  @Test fun getName() {
    assertThat(emp.name)
        .isEqualTo("Leonardo")
  }

  @Test fun getJob() {
    assertThat(emp.job)
        .isEqualTo(jobCFO)
  }

  @Test fun getSalary() {
    assertThat(emp.job.salary)
        .isEqualTo(BigInteger.valueOf(400000))
  }


}
