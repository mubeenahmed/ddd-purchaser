package order.infrastructure

import order.application.exception.NotFoundException
import order.domain.order.entities.Order
import order.domain.order.repositories.OrderRepository
import order.domain.order.valueobjects._
import order.infrastructure.table.{SlickOrder, SlickOrderedProduct, SlickPayment, SlickShippmentAddress}

import scala.concurrent.Future
import slick.jdbc.H2Profile.api._
import scala.concurrent.ExecutionContext.Implicits.global

class OrderRepsoitoryImpl extends OrderRepository with SlickConfiguration
{
  override def getListOfOrders : Future[Seq[Order]] =
    db.run(SlickOrder.order
      .join(SlickShippmentAddress.shippmentAddress)
      .on(_.id === _.orderId)
      .result
      .map( x => mapToSeqOfOrders(x) )
      .map(x => x.toSeq))


  override def getListOfUndeliveredOrders: Future[Seq[Order]] = ???


  override def getListOfOrdersByCustomer(customer: Customer): Future[Seq[Order]] =
    db.run(SlickOrder.order
      .filter(x => x.customerId === customer.customerId)
      .join(SlickShippmentAddress.shippmentAddress)
      .on(_.id === _.orderId)
      .result
      .map( x => mapToSeqOfOrders(x) )
      .map(x => x.toSeq))


  override def createOrder(order: Order): Future[Order] = ???


  override def updateOrder(order: Order): Future[Order] = ???


  override def cancelOrder(order: OrderStatus): Future[Order] = ???

  override def getOrderById(orderId: OrderId): Future[Order] = db.run(SlickOrder.order
    .join(SlickShippmentAddress.shippmentAddress)
    .on(_.id === _.orderId)
    .result.headOption.map {
      case Some(x) => mapToOrder(x)
      case None => throw NotFoundException("order not found")
    })




  private def mapToSeqOfOrders(x: Seq[((Int, String, String, Int), (Int, Int, String, String, String, String))]): Iterable[Order] =
    x.groupBy(_._1)
      .map(y => Order(OrderId(y._1._1.toString),
        OrderStatus(y._1._4.toString, true), List[OrderedProduct](), Customer(y._1._2),
        y._2.map(s =>
          ShippmentAddress(s._2._3 + s._2._4, s._2._6, s._2._5) ).head, null))

  private def mapToOrder(x: ((Int, String, String, Int), (Int, Int, String, String, String, String))): Order =
    Order(OrderId(x._1.toString), OrderStatus(x._1._4.toString, true),
      List[OrderedProduct](),
      Customer(x._1._2),
      ShippmentAddress(x._2._3 + x._2._4, x._2._6, x._2._5), null)

}
