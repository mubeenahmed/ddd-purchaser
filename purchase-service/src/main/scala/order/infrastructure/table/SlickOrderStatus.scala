package order.infrastructure.table


import slick.jdbc.H2Profile.api._
import slick.lifted
import slick.lifted._


class SlickOrderStatus(tag: Tag) extends Table[(Int, String)](tag, "order_status")
{
  def id = column[Int]("id", O.PrimaryKey)
  def status = column[String]("status")
  def * = (id, status)
}

object SlickOrderStatus
{
  lazy val orderStatus = lifted.TableQuery[SlickOrderStatus]
}
