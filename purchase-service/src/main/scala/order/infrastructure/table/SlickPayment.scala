package order.infrastructure.table

import slick.jdbc.H2Profile.api._
import slick.lifted._

class SlickPayment(tag: Tag) extends Table[(Int, Double, String)](tag, "payment")
{
  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def amount = column[Double]("amount")
  def paymentStatus = column[String]("payment_status")
  def * = (id, amount, paymentStatus)
}
