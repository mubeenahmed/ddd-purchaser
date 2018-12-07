package application

import domain.product.valueobjects.CategoryId
import domain.product.entities.{Category, Product}

import scala.concurrent.Future

trait ProductService {
  def getCategoryWithProductsByCategoryId(categoryId: CategoryId): Future[Seq[Product]]
  def saveProduct(category: Category): Future[Category]
}
