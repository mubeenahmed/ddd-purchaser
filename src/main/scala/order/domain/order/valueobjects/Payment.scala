package order.domain.order.valueobjects

import domain.shared.ValueObject

case class Payment(val paid: Double, val paymentStatus: String) extends ValueObject[Payment]
{
  override def sameAsValue(t: Payment): Boolean = ???
}
