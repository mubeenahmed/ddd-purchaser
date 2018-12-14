package order.domain.order.valueobjects

import shared.ValueObject

case class ShippmentAddress(val address: String, val city: String, val postalCode: String)
  extends ValueObject[ShippmentAddress]
{
  override def sameAsValue(t: ShippmentAddress): Boolean = ???
}
