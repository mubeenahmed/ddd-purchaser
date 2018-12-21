package order.domain.order.repositories

import order.domain.order.entities.Order
import order.domain.order.valueobjects.{Customer, OrderId, OrderStatus}

import scala.concurrent.Future

trait OrderRepository
{
  def getListOfOrders: Future[Seq[Order]]
  def getOrderById(orderId: OrderId): Future[Order]
  def getListOfUndeliveredOrders: Future[Seq[Order]]
  def getListOfOrdersByCustomer(customer: Customer): Future[Seq[Order]]
  def createOrder(order: Order): Future[Order]
  def updateOrder(order: Order): Future[Order]
  def cancelOrder(order: OrderStatus): Future[Order]
}
