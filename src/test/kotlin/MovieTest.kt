import org.junit.Test

import org.junit.Assert.*

/**
 * Created by Naren on 6/17/17.
 */
class MovieTest {

  val theGodfather: Movie = Movie("The Godfather", 9.2, 1972)

  val theDarkKnight: Movie = Movie("The Dark Knight", 8.9, 2008)

  val pulpFiction: Movie = Movie("Pulp Fiction", 8.9, 1994)

  val moviesList : List<Movie> = listOf(theDarkKnight, theGodfather, pulpFiction)

  @Test fun compareTo() {
    val sortedListOfMovies: List<Movie> =  moviesList.sorted().reversed()
    assertEquals(listOf(theGodfather, pulpFiction, theDarkKnight), sortedListOfMovies)
  }

  @Test fun comparatorTest() {
    val sortedListOfMovies: List<Movie> = moviesList.sortedWith(compareBy({ it.rating }, { it.year })).reversed()
    assertEquals(listOf(theGodfather, theDarkKnight, pulpFiction), sortedListOfMovies)
  }

  @Test fun getName() {
    assertEquals("The Godfather", theGodfather.name)
  }

  @Test fun getRating() {
    assertEquals(8.9, theDarkKnight.rating, 0.1)
  }

  @Test fun getYear() {
    assertEquals(1994, pulpFiction.year)
  }
}