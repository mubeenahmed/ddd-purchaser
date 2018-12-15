package order.domain.order.valueobjects

import shared.ValueObject

case class OrderStatus(status: String, isActive: Boolean) extends ValueObject[OrderStatus] {
  override def sameAsValue(t: OrderStatus): Boolean = t != null && this.status == t.status
}
