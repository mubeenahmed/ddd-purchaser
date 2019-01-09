package test.order.domain

import order.domain.order.entities.Order
import order.domain.order.valueobjects._
import org.scalatest.FlatSpec

class TestOrderDomain extends FlatSpec {

  "Order should be" should " provide" in {
    val orderId = OrderId("1")
    val status = OrderStatus("cancelled", true)
    val product = OrderedProduct("product-1002")
    val customer = Customer("customer-01")
    val shippmentAddress = ShippmentAddress("xyz", "Karachi", "8191")
    val payment = Payment(100.25, "paid")
    val order = Order(orderId, status, List(product), customer, shippmentAddress, payment)


  }

}
