package domain.product.valueobjects

import domain.shared.ValueObject

case class CategoryParentId(val id: String) extends ValueObject[CategoryParentId]
{
  override def sameAsValue(t: CategoryParentId): Boolean = t != null && t.id == id
}
