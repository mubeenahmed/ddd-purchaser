package order.infrastructure.table

import slick.jdbc.H2Profile.api._
import slick.lifted._

class SlickOrderedProduct(tag: Tag) extends Table[(Int, Int, String)](tag, "ordered_product")
{
  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def orderId = column[Int]("order_id")
  def productId = column[String]("product_id")
  def * = (id, orderId, productId)
}
