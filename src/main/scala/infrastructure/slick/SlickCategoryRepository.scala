package infrastructure.slick


import domain.product.entities.Category
import domain.product.repositories.CategoryRepository
import domain.product.valueobjects.{CategoryId, ProductId}
import domain.product.entities.Product
import infrastructure.slick.tables.{SlickCategory, SlickProduct}
import slick.jdbc.GetResult
import slick.jdbc.H2Profile.api._

import scala.concurrent.Future

class SlickCategoryRepository extends CategoryRepository with SlickRepository
{

  val product = TableQuery[SlickProduct]
  val category = TableQuery[SlickCategory]

  override def findOneById(categoryId: CategoryId): Future[Category] = ???

  override def findAll: Future[List[Category]] = ???

  override def findAllProductsByCategoryId(categoryId: CategoryId): Future[List[Product]] = ???

  override def findOneProductById(productId: ProductId): Future[Product] = ???

  override def save(category: Category): Future[Category] = ???

  override def nextCategoryId: CategoryId = ???
}
