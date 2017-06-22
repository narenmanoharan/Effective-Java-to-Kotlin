import Units.cm
import Units.m

/**
 * Created by Naren on 6/19/17.
 */

class HeightConverter {

  var value: Int = 1

  var from: Units = cm

  var to: Units = m

  private var convert : Int = value * 100

  var newValue: Int = this.convert
    private set

}

enum class Units {
  cm, m
}