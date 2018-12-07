package infrastructure.mongo

import domain.product.entities
import domain.product.entities.Category
import domain.product.repositories.CategoryRepository
import domain.product.valueobjects.{CategoryId, ProductId}

import org.mongodb.scala.bson.codecs.Macros._
import org.mongodb.scala.bson.codecs.DEFAULT_CODEC_REGISTRY
import org.bson.codecs.configuration.CodecRegistries.{fromRegistries, fromProviders}
import org.mongodb.scala.model.Filters._

import scala.concurrent.Future

class CategoryProductRepositoryImpl extends CategoryRepository with MongoDbConfiguration
{
  val codecRegistry = fromRegistries(fromProviders(classOf[Category]), DEFAULT_CODEC_REGISTRY )

  override def findOneById(categoryId: CategoryId): Future[Category] =
    database.withCodecRegistry(codecRegistry)
      .getCollection[Category]("category_product")
      .find(equal("_id", categoryId.id)).first.toFuture


  override def findAll: Future[List[Category]] = ???

  override def findAllProductsByCategoryId(categoryId: CategoryId): Future[List[entities.Product]] = ???

  override def findOneProductById(productId: ProductId): Future[entities.Product] = ???

  override def save(category: Category): Future[Category] = ???

  override def nextCategoryId: CategoryId = ???
}
