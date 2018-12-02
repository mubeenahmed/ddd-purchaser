package endpoint.rest.product

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.server.Directives._
import application.ProductService
import application.impl.ProductServiceImpl
import domain.product.entities.{Category, Product}
import domain.product.repositories.CategoryRepository
import domain.product.valueobjects.{CategoryId, CategoryParentId, ProductId, ProductRating}
import infrastructure.slick.SlickCategoryRepository
import spray.json._
import scala.concurrent.Future


trait JsonSupport extends SprayJsonSupport with DefaultJsonProtocol
{
  implicit val productDto = jsonFormat5(ProductDto)
  implicit val categoryDto = jsonFormat4(CategoryDto)
}


object ProductRestApi extends JsonSupport
{
  def route = path("products/")
  {
    get {
      pathPrefix("category")
      {
        path(IntNumber) {
          categoryId => complete(findAllProductsByCategoryId(categoryId))
        }
      }
    } ~
    post {
      entity(as[CategoryDto])
      {
        categoryDto =>
      }
    }
  }

  def findAllProductsByCategoryId(id: Long): Future[List[Product]] =
  {
    val productCategoryRepository: CategoryRepository = new SlickCategoryRepository
    val productService: ProductService = new ProductServiceImpl(categoryRepository = productCategoryRepository)
    productService.getAllProductsByCategoryId(CategoryId(id))
  }

  def saveProduct(categoryDto: CategoryDto): Category  =
  {
    val productCategoryRepository: CategoryRepository = new SlickCategoryRepository
    val productService: ProductService = new ProductServiceImpl(productCategoryRepository)
    val category = categoryDto.toDomain
    productService.saveProduct(category)
  }

}
