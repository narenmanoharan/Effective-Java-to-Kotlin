import org.junit.Test

import org.junit.Assert.assertEquals

/**
 * Created by Naren on 6/15/17.
 */
class DatabaseTest {

  private val db : Database = Database

  @Test fun getVersion() {
    assertEquals(0.1, Database.getVersion(), 0.1)
  }

  @Test fun bumpUpVersion() {
    assertEquals(0.2, Database.bumpUpVersion(), 0.1)
  }

  @Test fun getInstance() {
    assertEquals(db, Database.getInstance())
  }
}