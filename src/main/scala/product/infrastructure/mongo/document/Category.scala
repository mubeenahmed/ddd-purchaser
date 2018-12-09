package product.infrastructure.mongo.document

import product.domain.product.entities.{Product, Category}
import product.domain.product.valueobjects.{CategoryId, CategoryParentId}
import org.bson.types.ObjectId

object Category {
  def apply(name: String, products: List[Product], parentId: String) =
    product.domain.product.entities.Category(CategoryId(new ObjectId().toString), products, name, Option(CategoryParentId(parentId)))

  def apply(id: ObjectId, name: String, products: List[Product], parentId: String) =
    product.domain.product.entities.Category(CategoryId(id.toString), products, name, Option(CategoryParentId(parentId)))
}
