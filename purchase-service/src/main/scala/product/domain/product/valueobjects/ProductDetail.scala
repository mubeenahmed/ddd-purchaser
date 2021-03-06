package product.domain.product.valueobjects

import shared.ValueObject

case class ProductDetail(val description: String) extends ValueObject[ProductDetail]{
  override def sameAsValue(t: ProductDetail): Boolean = t != null && t.description == description
}
