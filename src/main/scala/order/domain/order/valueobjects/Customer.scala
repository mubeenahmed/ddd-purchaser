package order.domain.order.valueobjects

import domain.shared.ValueObject

case class Customer(val customerId: String) extends ValueObject[Customer]
{
  override def sameAsValue(t: Customer): Boolean = ???
}
