package domain.product.entities

import domain.product.valueobjects.{ProductId, ProductRating}
import domain.shared.Entity

case class Product(val id: ProductId,
                   val productName: String,
                   val productRating: ProductRating,
                   val price: Double)
  extends Entity[ProductId]
{

  override def sameIdentityAs(t: ProductId): Boolean = t != null && id.sameAsValue(t)

}
