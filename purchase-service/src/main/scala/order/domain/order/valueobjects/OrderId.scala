package order.domain.order.valueobjects

import shared.ValueObject

case class OrderId(val id: String) extends ValueObject[OrderId]
{
  override def sameAsValue(t: OrderId): Boolean = t != null && this.id == t.id
}
