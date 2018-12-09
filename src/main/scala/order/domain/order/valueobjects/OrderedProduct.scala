package order.domain.order.valueobjects

import domain.shared.ValueObject

case class OrderedProduct(val productId: String) extends ValueObject[OrderedProduct] {
  override def sameAsValue(t: OrderedProduct): Boolean = t != null && this.productId == t.productId
}
