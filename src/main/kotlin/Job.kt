import java.math.BigInteger

/**
 * Created by Naren on 6/21/17.
 */


data class Job(val position: Position, val salary: BigInteger, val id: Int)

data class Employee(val name: String, var job: Job)


enum class Position {
  CEO, CTO, CFO, Manager, Lead, Engineer, Intern
}
