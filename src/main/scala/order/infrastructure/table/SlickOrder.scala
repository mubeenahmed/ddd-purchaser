package order.infrastructure.table

import java.time.LocalDateTime

import slick.jdbc.H2Profile.api._
import slick.lifted._

class SlickOrder(tag: Tag)  extends Table[(Int, String)](tag, "order")
{
  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def customerId = column[String]("customer_id")

  def * = (id, customerId)
}
