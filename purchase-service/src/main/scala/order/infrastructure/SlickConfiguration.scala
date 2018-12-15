package order.infrastructure


import slick.jdbc.H2Profile.api._
import scala.concurrent.ExecutionContext.Implicits.global

trait SlickConfiguration {
  val db = Database.forConfig("h2mem1")
  try {
    // ...
  } finally db.close
}
