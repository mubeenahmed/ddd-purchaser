package order.domain.order.entities

import order.domain.order.valueobjects._
import domain.shared.Entity

case class Order(val orderId: OrderId,
                 val status: OrderStatus,
                 val products: List[OrderedProduct],
                 val customer: Customer,
                 val shippment: Shippment,
                 val payment: Payment ) extends Entity[OrderId]
{
  override def sameIdentityAs(t: OrderId): Boolean = t != null && orderId.sameAsValue(t)
}
