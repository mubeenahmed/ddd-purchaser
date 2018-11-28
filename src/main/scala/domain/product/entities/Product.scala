package domain.product.entities

import domain.product.valueobjects.ProductId
import domain.shared.Entity

case class Product(val productId: ProductId,
                   val productName: String,
                   val productRating: ProductRating,
                   val price: Double)
  extends Entity[Product]
{

  override def sameIdentityAs(t: Product): Boolean = t != null && productId.sameAsValue(t.productId)

}
