package application

import domain.product.valueobjects.CategoryId
import domain.product.entities.Product

trait ProductService {
  def getAllProductsByCategoryId(categoryId: CategoryId): List[Product]
}
