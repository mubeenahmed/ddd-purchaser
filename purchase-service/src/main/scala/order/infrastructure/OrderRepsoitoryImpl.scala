package order.infrastructure

import order.domain.order.entities.Order
import order.domain.order.repositories.OrderRepository
import order.domain.order.valueobjects.{Customer, OrderId, OrderStatus, OrderedProduct}
import order.infrastructure.table.{SlickOrder, SlickOrderedProduct, SlickPayment, SlickShippmentAddress}

import scala.concurrent.Future

class OrderRepsoitoryImpl extends OrderRepository with SlickConfiguration
{
  override def getListOfOrderById(orderId: OrderId): Future[Seq[Order]] = ???

  override def getListOfUndeliveredOrders: Future[Seq[Order]] = ???

  override def getListOfOrdersByCustomer(customer: Customer): Future[Seq[Order]] = ???

  override def createOrder(order: Order): Future[Order] = ???

  override def updateOrder(order: Order): Future[Order] = ???

  override def cancelOrder(order: OrderStatus): Future[Order] = ???
}
