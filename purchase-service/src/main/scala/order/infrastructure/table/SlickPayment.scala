package order.infrastructure.table

import slick.jdbc.H2Profile.api._
import slick.lifted
import slick.lifted._

class SlickPayment(tag: Tag) extends Table[(Int, Double, String, Int)](tag, "payment")
{
  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def amount = column[Double]("amount")
  def paymentStatus = column[String]("payment_status")
  def orderId = column[Int]("order_id")

  def order = foreignKey("ORDER", orderId, SlickOrderedProduct.orderProduct )(_.id)
  def * = (id, amount, paymentStatus, orderId)
}

object SlickPayment
{
  lazy val payment = lifted.TableQuery[SlickPayment]
}