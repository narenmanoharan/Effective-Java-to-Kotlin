import Position.CFO
import java.math.BigInteger

/**
 * Created by Naren on 6/22/17.
 */

data class CEO(val name: String, private var job: Job = Job(CFO, BigInteger.valueOf(500000), 1000)) {

  fun getSalary() = job.salary

  fun getJobId() = job.id
}