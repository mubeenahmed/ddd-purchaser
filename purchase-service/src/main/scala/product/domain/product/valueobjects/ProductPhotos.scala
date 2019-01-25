package product.domain.product.valueobjects

import shared.ValueObject

case class ProductPhotos(val path: String,
                         val imageName: String,
                         val extension: String) extends ValueObject[ProductPhotos] {
  override def sameAsValue(t: ProductPhotos): Boolean = ???
}
