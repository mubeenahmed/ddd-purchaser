package order.infrastructure

import order.domain.order.entities.Order
import order.domain.order.repositories.OrderRepository
import order.domain.order.valueobjects.{Customer, OrderId, OrderStatus}

class OrderRepsoitoryImpl extends OrderRepository with SlickConfiguration
{
  override def getListOfOrderById(orderId: OrderId): Unit = ???

  override def getListOfUndeliveredOrders: Unit = ???

  override def getListOfOrdersByCustomer(customer: Customer): Unit = ???

  override def createOrder(order: Order): Unit = ???

  override def updateOrder(order: Order): Unit = ???

  override def cancelOrder(order: OrderStatus): Unit = ???
}
