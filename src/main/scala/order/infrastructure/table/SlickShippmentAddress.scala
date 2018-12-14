package order.infrastructure.table


import slick.jdbc.H2Profile.api._
import slick.lifted._


class SlickShippmentAddress(tag: Tag) extends Table[(Int, Int, String, String, String)](tag, "shippment_address")
{
  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def orderId = column[Int]("order_id")
  def address1 = column[String]("address1")
  def address2 = column[String]("address2")
  def postalCode = column[String]("postal_code")

  def * = (id, orderId, address1, address2, postalCode)
}
