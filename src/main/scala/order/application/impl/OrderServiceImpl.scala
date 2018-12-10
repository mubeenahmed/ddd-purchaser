package order.application.impl

import order.application.OrderService
import order.domain.order.entities.Order
import order.domain.order.repositories.OrderRepository
import order.domain.order.valueobjects.{Customer, OrderId}

import scala.concurrent.Future

class OrderServiceImpl(orderRepository: OrderRepository) extends OrderService
{
  override def createOrder(order: Order): Future[Order] = ???

  override def updateOrder(order: Order): Future[Order] = ???

  override def getOrderById(orderId: OrderId): Future[Order] = ???

  override def getOrderByCustomer(customerId: Customer): Future[Seq[Order]] = ???

  override def getOrderByCustomer(customerId: Customer, orderId: OrderId): Future[Order] = ???
}
