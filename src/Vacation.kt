import Mode.CAR

/**
 * Created by Naren on 6/14/17.
 */

// Builder Pattern
class Vacation (val destination: String?,
                val date: Int?,
                val month: Int?,
                val year: Int?,
                val duration: Int,
                val mode: Mode,
                val cost: Int) {
  private constructor(builder: Builder) : this(builder.destination,
                                               builder.date,
                                               builder.month,
                                               builder.year,
                                               builder.duration,
                                               builder.mode,
                                               builder.cost)

  companion object {
    inline fun build(mode: Mode, cost: Int, block: Builder.() -> Unit) = Builder(mode, cost).apply(block).build()
  }

  class Builder(val mode: Mode ,val cost: Int) {

    var destination: String? = null
    var date: Int? = null
    var month: Int? = null
    var year: Int? = null
    var duration: Int = 0

    fun build() = Vacation(this)
  }
}

enum class Mode {
  FLIGHT, TRAIN, CAR, BOAT
}