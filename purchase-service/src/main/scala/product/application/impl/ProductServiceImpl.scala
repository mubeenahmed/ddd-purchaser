package product.application.impl

import product.application.ProductService
import product.domain.product.repositories.CategoryRepository
import product.domain.product.valueobjects.CategoryId
import product.domain.product.entities.{Category, Product}

import scala.concurrent.Future

class ProductServiceImpl(val categoryRepository: CategoryRepository) extends ProductService
{
  override def getCategoryWithProductsByCategoryId(categoryId: CategoryId): Future[Seq[Product]] =
    categoryRepository.findAllProductsByCategoryId(categoryId)

  override def saveProduct(category: Category): Future[Category] =
    categoryRepository.save(category)
}
