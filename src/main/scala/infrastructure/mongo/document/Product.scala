package infrastructure.mongo.document

import domain.product.entities.Product
import domain.product.valueobjects.{ProductId, ProductRating}
import org.bson.types.ObjectId

object Product {

  def apply(name: String, rating: Double, price: Double) = Product(ProductId(new ObjectId().toString), name, ProductRating(rating), price)
  def apply(id: ObjectId, name: String, rating: Double, price: Double) =
    Product(ProductId(id.toString), name, ProductRating(rating), price)
}
