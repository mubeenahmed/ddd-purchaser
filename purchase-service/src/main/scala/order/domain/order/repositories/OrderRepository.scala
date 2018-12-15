package order.domain.order.repositories

import order.domain.order.entities.Order
import order.domain.order.valueobjects.{Customer, OrderId, OrderStatus}

trait OrderRepository
{
  def getListOfOrderById(orderId: OrderId)
  def getListOfUndeliveredOrders
  def getListOfOrdersByCustomer(customer: Customer)
  def createOrder(order: Order)
  def updateOrder(order: Order)
  def cancelOrder(order: OrderStatus)
}
