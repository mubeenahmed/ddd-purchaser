package product.infrastructure.mongo.document

import product.domain.product.entities.Product
import product.domain.product.valueobjects.{ProductId, ProductPhotos, ProductRating}
import org.bson.types.ObjectId

object Product {

  def apply(name: String, rating: Double, price: Double, productPhotos: List[ProductPhotos]) =
    product.domain.product.entities.Product(ProductId(new ObjectId().toString), name, ProductRating(rating), productPhotos, price)
  def apply(id: ObjectId, name: String, rating: Double, productPhotos: List[ProductPhotos], price: Double) =
    product.domain.product.entities.Product(ProductId(id.toString), name, ProductRating(rating), productPhotos, price)
}
