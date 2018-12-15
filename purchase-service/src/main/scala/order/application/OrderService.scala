package order.application

import order.domain.order.entities.Order
import order.domain.order.valueobjects.{Customer, OrderId}

import scala.concurrent.Future

trait OrderService
{
  def createOrder(order: Order): Future[Order]
  def updateOrder(order: Order): Future[Order]
  def getOrderById(orderId: OrderId): Future[Order]
  def getOrderByCustomer(customerId: Customer): Future[Seq[Order]]
  def getOrderByCustomer(customerId: Customer, orderId: OrderId): Future[Order]

}
