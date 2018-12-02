package infrastructure.slick


import domain.product.entities.Category
import domain.product.repositories.CategoryRepository
import domain.product.valueobjects.{CategoryId, ProductId}
import domain.product.entities.Product
import slick.jdbc.GetResult
import slick.jdbc.H2Profile.api._

import scala.concurrent.Future

class SlickCategoryRepository extends CategoryRepository with SlickRepository
{

  val getProductResult = GetResult(r => Product(r.<<, r.<<, r.<<, r.<<))
  val getCategoryResult = GetResult(r => Category(r.<<, r.<<, r.<<, r.<<))

  override def findOneById(categoryId: CategoryId): Future[Category] =
    db.run(sql"select * from category where id = ${categoryId.id}".as[Category](getCategoryResult))
      .map(c => c.head)


  override def findAll: Future[List[Category]] =
    db.run(sql"select * from category".as[Category](getCategoryResult))
      .map(c => c.toList)

  override def findAllProductsByCategoryId(categoryId: CategoryId): Future[List[Product]] =
    db.run(sql"select * from product where categoryId = ${categoryId.id}".as[Product](getProductResult))
      .map(c => c.toList)

  override def findOneProductById(productId: ProductId): Future[Product] =
    db.run(sql"select * from product where productId = ${productId.id}".as[Product](getProductResult))
      .map(c => c.head)

  override def save(category: Category): Future[Category] = ???

  override def nextCategoryId: CategoryId = ???
}
