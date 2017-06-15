/**
 * Created by Naren on 6/15/17.
 */

object Database {

  private var dbVersion : Double = 0.1

  fun getVersion(): Double {
    return dbVersion
  }

  fun bumpUpVersion(): Double {
    dbVersion += 0.1
    return dbVersion
  }

  fun getInstance(): Database {
    return this
  }

}
