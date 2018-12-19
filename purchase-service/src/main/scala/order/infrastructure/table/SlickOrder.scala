package order.infrastructure.table

import java.time.LocalDateTime

import slick.jdbc.H2Profile.api._
import slick.lifted
import slick.lifted._

class SlickOrder(tag: Tag)  extends Table[(Int, String, String, Int)](tag, "order")
{
  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def customerId = column[String]("customer_id")
  def orderCode = column[String]("order_code", O.Unique)
  def orderStatusId = column[Int]("order_status_id")

  def orderStatus = foreignKey("order_status", orderStatusId, SlickOrderStatus.orderStatus)(_.id)
  def * = (id, customerId, orderCode, orderStatusId)
}

object SlickOrder
{
  lazy val order = lifted.TableQuery[SlickOrder]
}
