package product.domain.product.entities

import product.domain.product.valueobjects.{ProductId, ProductRating}
import shared.Entity

case class Product(val productId: ProductId,
                   val productName: String,
                   val productRating: ProductRating,
                   val price: Double)
  extends Entity[Product]
{

  override def sameIdentityAs(t: Product): Boolean = t != null && productId.sameAsValue(t.productId)

}
