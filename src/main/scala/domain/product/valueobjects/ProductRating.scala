package domain.product.valueobjects

import domain.shared.ValueObject

case class ProductRating(val rate: Double) extends ValueObject[ProductRating] {
  override def sameAsValue(t: ProductRating): Boolean = t != null && t.rate == rate
}
