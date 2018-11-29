package infrastructure.slick


import domain.product.entities.Category
import domain.product.repositories.CategoryRepository
import domain.product.valueobjects.{CategoryId, ProductId}
import domain.product.entities.Product

class SlickCategoryRepository extends CategoryRepository with SlickRepository
{
  override def findById(categoryId: CategoryId): Category = ???

  override def findAll: List[Category] = ???

  override def findProductsByCategoryId(categoryId: CategoryId): List[Product] = ???

  override def findProductsByCategoryId(categoryId: CategoryId, productId: ProductId): Product = ???

  override def save(category: Category): Category = ???

  override def nextCategoryId: CategoryId = ???
}
