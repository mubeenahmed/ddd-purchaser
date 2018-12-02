package application.impl

import application.ProductService
import domain.product.repositories.CategoryRepository
import domain.product.valueobjects.CategoryId
import domain.product.entities.Product

import scala.concurrent.Future

class ProductServiceImpl(val categoryRepository: CategoryRepository) extends ProductService
{
  override def getAllProductsByCategoryId(categoryId: CategoryId): Future[List[Product]] =
    categoryRepository.findAllProductsByCategoryId(categoryId)

  override def saveProduct(product: Product): Product = ???
}
