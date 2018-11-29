package infrastructure.slick

import slick.jdbc.H2Profile.api._
import scala.concurrent.ExecutionContext.Implicits.global

trait SlickRepository {
  val db = Database.forConfig("h2mem1")
}
