package product.domain.product.repositories


import product.domain.product.entities.Category
import product.domain.product.valueobjects.{CategoryId, ProductId}
import product.domain.product.entities.Product

import scala.concurrent.Future

trait CategoryRepository
{
  def findOneById(categoryId: CategoryId): Future[Category]
  def findAll: Future[Seq[Category]]

  def findAllProductsByCategoryId(categoryId: CategoryId): Future[Seq[Product]]
  def findOneProductById(categoryId: CategoryId, productId: ProductId): Future[Product]

  def save(category: Category): Future[Category]
  def nextCategoryId: CategoryId
}
