package endpoint.rest.product

import io.bfil.automapper._
import domain.product.entities.{Category, Product}
import domain.product.valueobjects.{ProductId, ProductRating}

case class ProductIdDto(val id: Long)
case class CategoryIdDto(val id: Long)
case class ProductRatingDto(val id: Long)
case class CategoryParentIdDto(val id: Long)

case class ProductDto(productId: ProductIdDto,
                      productName: String,
                      productRating: ProductRatingDto,
                      price: Double)
{
  def toDomain = automap(this).to[Product]
}


case class CategoryDto(categoryId: CategoryIdDto,
                       products: List[ProductDto],
                       categoryName: String,
                       parentId: Option[CategoryParentIdDto])
{
  def toDomain = automap(this).to[Category]
}
