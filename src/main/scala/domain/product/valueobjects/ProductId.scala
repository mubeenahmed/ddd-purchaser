package domain.product.valueobjects

import domain.shared.ValueObject

case class ProductId(val id: Long) extends ValueObject[ProductId] {
  override def sameAsValue(t: ProductId): Boolean = t != null && t.id == id
}
