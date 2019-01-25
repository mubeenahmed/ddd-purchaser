package test.order.application

import order.application.OrderService
import order.application.impl.OrderServiceImpl
import order.domain.order.entities.Order
import order.domain.order.repositories.OrderRepository
import order.domain.order.valueobjects._
import org.scalamock.scalatest.MockFactory
import org.scalatest.AsyncFlatSpec

import scala.concurrent.Future

class TestOrderService extends AsyncFlatSpec with MockFactory {

  val noCustomer = Customer("noCustomer")

  val goodCustomer = Customer("1")
  val goodOrder = Order( OrderId("1"),
    OrderStatus("delivered", true),
    List(OrderedProduct("1"), OrderedProduct("2")),
    goodCustomer,
    ShippmentAddress("xyz", "city", "7199"),
    Payment(100.00, "paid"))

  val orderRepository = mock[OrderRepository]

  "Order Service" should "give list of orders by customer id" in {
    (orderRepository.getListOfOrdersByCustomer _).when(goodCustomer)
      .returns(Future { Vector(goodOrder) })

    val orderService: OrderService = new OrderServiceImpl(orderRepository)
    orderService.getOrderByCustomer(goodCustomer)
      .map(x => {
        assert(x.size == 1)
        assert(x.head.products.size == 2)
      })
  }

  "Order Service" should "give no list of orders by no customer id" in {
    (orderRepository.getListOfOrdersByCustomer _).when(noCustomer)
      .returns(Future { Vector() })

    val orderService: OrderService = new OrderServiceImpl(orderRepository)
    orderService.getOrderByCustomer(noCustomer)
      .map(x => {
        assert(x.size == 0)
        assert(x.head.products.size == 0)
      })
  }
}
