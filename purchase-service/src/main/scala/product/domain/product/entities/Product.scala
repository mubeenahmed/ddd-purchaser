package product.domain.product.entities

import product.domain.product.valueobjects.{ProductId, ProductPhotos, ProductRating}
import shared.Entity

case class Product(val productId: ProductId,
                   val productName: String,
                   val productRating: ProductRating,
                   val productPhotos: List[ProductPhotos],
                   val price: Double)
  extends Entity[Product]
{

  override def sameIdentityAs(t: Product): Boolean = t != null && productId.sameAsValue(t.productId)

}
