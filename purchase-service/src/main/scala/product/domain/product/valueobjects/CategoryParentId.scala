package product.domain.product.valueobjects

import shared.ValueObject

case class CategoryParentId(val id: String) extends ValueObject[CategoryParentId]
{
  override def sameAsValue(t: CategoryParentId): Boolean = t != null && t.id == id
}
