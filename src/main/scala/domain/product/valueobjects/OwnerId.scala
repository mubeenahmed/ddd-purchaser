package domain.product.valueobjects

import domain.shared.ValueObject

case class OwnerId(val id: Long) extends ValueObject[OwnerId] {
  override def sameAsValue(t: OwnerId): Boolean = t != null && t.id == id
}
