package order.infrastructure.table

import order.domain.order.entities.Order
import slick.jdbc.H2Profile.api._
import slick.lifted
import slick.lifted._

class SlickOrderedProduct(tag: Tag) extends Table[(Int, Int, String)](tag, "ordered_product")
{
  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def orderId = column[Int]("order_id")
  def productId = column[String]("product_id")
  def order = foreignKey("ORDER", orderId, SlickOrderedProduct.orderProduct )(_.id)
  def * = (id, orderId, productId)
}

object SlickOrderedProduct
{
  lazy val orderProduct = lifted.TableQuery[SlickOrderedProduct]
}