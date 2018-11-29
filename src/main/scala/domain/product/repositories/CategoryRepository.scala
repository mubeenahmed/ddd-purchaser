package domain.product.repositories


import domain.product.entities.Category
import domain.product.valueobjects.{CategoryId, ProductId}
import domain.product.entities.Product

trait CategoryRepository
{
  def findById(categoryId: CategoryId): Category
  def findAll: List[Category]
  def findProductsByCategoryId(categoryId: CategoryId): List[Product]
  def findProductsByCategoryId(categoryId: CategoryId, productId: ProductId): Product
  def save(category: Category): Category
  def nextCategoryId: CategoryId
}
