package product.endpoint.rest.product

import io.bfil.automapper._
import product.domain.product.entities.{Category, Product}
import scala.concurrent.ExecutionContext.Implicits.global

case class ProductIdDto(val id: String)
case class CategoryIdDto(val id: String)
case class ProductRatingDto(val rate: Double)
case class CategoryParentIdDto(val id: String)

case class ProductDto(productId: ProductIdDto,
                      productName: String,
                      productRating: ProductRatingDto,
                      price: Double)
{
  def toDomain = automap(this).to[Product]
}


case class CategoryDto(catId: CategoryIdDto,
                       products: List[ProductDto],
                       name: String,
                       parentId: Option[CategoryParentIdDto])
{
  def toDomain = automap(this).to[Category]
}
