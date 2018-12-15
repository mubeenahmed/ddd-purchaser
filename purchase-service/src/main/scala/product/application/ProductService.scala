package product.application

import product.domain.product.valueobjects.CategoryId
import product.domain.product.entities.{Category, Product}

import scala.concurrent.Future

trait ProductService {
  def getCategoryWithProductsByCategoryId(categoryId: CategoryId): Future[Seq[Product]]
  def saveProduct(category: Category): Future[Category]
}
