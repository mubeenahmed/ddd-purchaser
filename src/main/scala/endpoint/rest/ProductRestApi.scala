package endpoint.rest

import akka.http.scaladsl.server.Directives._
import application.ProductService
import application.impl.ProductServiceImpl
import domain.product.repositories.CategoryRepository
import domain.product.valueobjects.{CategoryId, ProductId}
import infrastructure.slick.SlickCategoryRepository
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import domain.product.entities.{Product, ProductRating}
import spray.json._


trait JsonSupport extends SprayJsonSupport with DefaultJsonProtocol
{
  implicit val productIdFormat = jsonFormat1(ProductId)
  implicit val productRatingFormat = jsonFormat1(ProductRating)
  implicit val productFormat = jsonFormat4(Product)
}


object ProductRestApi extends JsonSupport
{
  def route = path("products")
  {
    get {
      complete(findAllProductsByCategoryId(1))
    }
  }

  def findAllProductsByCategoryId(id: Long): List[Product] =
  {
    val productCategoryRepository: CategoryRepository = new SlickCategoryRepository
    val productService: ProductService = new ProductServiceImpl(categoryRepository = productCategoryRepository)
    val listOfProducts: List[Product] = productService.getAllProductsByCategoryId(CategoryId(id))
    listOfProducts
  }
}
