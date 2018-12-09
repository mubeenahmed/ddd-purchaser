package product.domain.product.valueobjects

import domain.shared.ValueObject

case class CategoryId(val id: String) extends ValueObject[CategoryId] {
  override def sameAsValue(t: CategoryId): Boolean = t != null && this.id == t.id
}
