package infrastructure.slick.tables

import domain.product.entities.Product
import domain.product.valueobjects.{ProductId, ProductRating}
import slick.jdbc.H2Profile.api._

import scala.concurrent.ExecutionContext.Implicits.global
import slick.lifted._

class SlickProduct(tag: Tag) extends Table[(Int, String,Double, Double, Int)](tag, "product")
{
  def id = column[Int]("id", O.PrimaryKey)
  def productName = column[String]("product_name")
  def producePrice = column[Double]("product_price")
  def productRating = column[Double]("product_rating")
  def categoryId = column[Int]("category_id")

  override def * = (id, productName, producePrice, productRating, categoryId)
}
