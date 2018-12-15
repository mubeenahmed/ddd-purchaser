package product.domain.product.valueobjects

import shared.ValueObject

case class OwnerRating(val rating: Double) extends ValueObject[OwnerRating] {
  override def sameAsValue(t: OwnerRating): Boolean = t != null && t.rating == rating
}
