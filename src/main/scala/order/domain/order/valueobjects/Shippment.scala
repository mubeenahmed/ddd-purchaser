package order.domain.order.valueobjects

import shared.ValueObject

case class Shippment(val address: String, val city: String, val postalCode: String)
  extends ValueObject[Shippment]
{
  override def sameAsValue(t: Shippment): Boolean = ???
}
