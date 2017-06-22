/**
 * Created by Naren on 6/17/17.
 */


data class Movie(val name: String, val rating: Double, val year: Int) : Comparable<Movie> {

  override fun compareTo(other: Movie): Int {
    return this.rating.compareTo(other.rating)
  }

}






