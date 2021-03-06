package product.endpoint.rest.product

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.server.Directives._
import product.application.ProductService
import product.application.impl.ProductServiceImpl
import product.domain.product.entities.{Category, Product}
import product.domain.product.repositories.CategoryRepository
import product.domain.product.valueobjects._
import product.infrastructure.mongo.MongoCategoryRepository
import spray.json._

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

trait JsonSupport extends SprayJsonSupport with DefaultJsonProtocol
{
//  implicit val productIdDto = jsonFormat1(ProductIdDto)
//  implicit val categoryIdDto = jsonFormat1(CategoryIdDto)
//  implicit val parentCategoryIdDto = jsonFormat1(CategoryParentIdDto)
//  implicit val productRatingDto = jsonFormat1(ProductRatingDto)
//
//  implicit val productDto = jsonFormat4(ProductDto)
//  implicit val categoryDto = jsonFormat4(CategoryDto)

  implicit val productIdDto = jsonFormat1(ProductId)
  implicit val categoryIdDto = jsonFormat1(CategoryId)
  implicit val parentCategoryIdDto = jsonFormat1(CategoryParentId)
  implicit val productRatingDto = jsonFormat1(ProductRating)
  implicit val productPhotos = jsonFormat3(ProductPhotos)

  implicit val productDto = jsonFormat5(Product)
  implicit val categoryDto = jsonFormat4(Category)
}


object ProductRestApi extends JsonSupport
{
  def route =
  pathPrefix("category")
  {
    get
    {
      path("product" / Segment)
      {
        categoryId: String => complete(findAllProductsByCategoryId(categoryId))
      }
    }
  }

  def findAllProductsByCategoryId(id: String): Future[Seq[Product]] =
  {
    val productCategoryRepository: CategoryRepository = new MongoCategoryRepository
    val productService: ProductService = new ProductServiceImpl(categoryRepository = productCategoryRepository)
    productService.getCategoryWithProductsByCategoryId(CategoryId(id))
      //.map(products => products.map(automap(_).to[ProductDto]) )
  }

  def saveProduct(categoryDto: CategoryDto): Future[Category]  =
  {

    val productCategoryRepository: CategoryRepository = new MongoCategoryRepository
    val productService: ProductService = new ProductServiceImpl(productCategoryRepository)
    val category = categoryDto.toDomain
    productService.saveProduct(category)
  }

}
