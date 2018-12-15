package order.domain.order.valueobjects

import shared.ValueObject

case class Customer(val customerId: String) extends ValueObject[Customer]
{
  override def sameAsValue(t: Customer): Boolean = ???
}
