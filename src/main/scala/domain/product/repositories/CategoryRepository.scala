package domain.product.repositories


import domain.product.entities.Category
import domain.product.valueobjects.{CategoryId, ProductId}
import domain.product.entities.Product
import domain.shared.Entity

import scala.concurrent.Future

trait CategoryRepository
{
  def findOneById(categoryId: CategoryId): Future[Category]
  def findAll: Future[List[Category]]

  def findAllProductsByCategoryId(categoryId: CategoryId): Future[List[Product]]
  def findOneProductById(productId: ProductId): Future[Product]

  def save(category: Category): Future[Category]
  def nextCategoryId: CategoryId
}
