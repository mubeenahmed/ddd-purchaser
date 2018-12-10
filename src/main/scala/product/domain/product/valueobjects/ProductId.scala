package product.domain.product.valueobjects

import shared.ValueObject

case class ProductId(val id: String) extends ValueObject[ProductId] {
  override def sameAsValue(t: ProductId): Boolean = t != null && t.id == id
}
