package application.impl

import application.ProductService
import domain.product.repositories.CategoryRepository
import domain.product.valueobjects.CategoryId
import domain.product.entities.{Category, Product}

import scala.concurrent.Future

class ProductServiceImpl(val categoryRepository: CategoryRepository) extends ProductService
{
  override def getCategoryWithProductsByCategoryId(categoryId: CategoryId): Future[Seq[Product]] =
    categoryRepository.findAllProductsByCategoryId(categoryId)

  override def saveProduct(category: Category): Future[Category] =
    categoryRepository.save(category)
}
