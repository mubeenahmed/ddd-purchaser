package application.impl

import application.ProductService
import domain.product.repositories.CategoryRepository
import domain.product.valueobjects.CategoryId
import domain.product.entities.Product

class ProductServiceImpl(val categoryRepository: CategoryRepository) extends ProductService
{
  override def getAllProductsByCategoryId(categoryId: CategoryId): List[Product] =
    categoryRepository.findProductsByCategoryId(categoryId)
}
