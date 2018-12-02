package application

import domain.product.valueobjects.CategoryId
import domain.product.entities.{Category, Product}

import scala.concurrent.Future

trait ProductService {
  def getAllProductsByCategoryId(categoryId: CategoryId): Future[List[Product]]
  def saveProduct(category: Category): Product
}
