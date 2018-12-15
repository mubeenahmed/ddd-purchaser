package product.infrastructure.mongo

import product.domain.product.entities
import product.domain.product.entities.{Category, Product}
import product.domain.product.repositories.CategoryRepository
import product.domain.product.valueobjects.{CategoryId, ProductId}
import org.mongodb.scala.bson.codecs.Macros._
import org.mongodb.scala.bson.codecs.DEFAULT_CODEC_REGISTRY
import org.bson.codecs.configuration.CodecRegistries.{fromProviders, fromRegistries}
import org.mongodb.scala.Completed
import org.mongodb.scala.bson.ObjectId
import org.mongodb.scala.model.Filters._

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

class MongoCategoryRepository extends CategoryRepository with MongoDbConfiguration
{
  private val collectionName = "category_product"

  val codecRegistry = fromRegistries(fromProviders(classOf[Category]), DEFAULT_CODEC_REGISTRY )

  override def findOneById(categoryId: CategoryId): Future[Category] =
    database.withCodecRegistry(codecRegistry)
      .getCollection[Category](collectionName)
      .find(equal("_id", categoryId.id))
      .head


  override def findAll: Future[Seq[Category]] =
    database.withCodecRegistry(codecRegistry)
      .getCollection[Category](collectionName)
      .find
      .toFuture

  override def findAllProductsByCategoryId(categoryId: CategoryId): Future[Seq[entities.Product]] =
    database.withCodecRegistry(codecRegistry)
      .getCollection[Category](collectionName)
      .find(equal("_id", categoryId.id))
      .headOption
      .collect({
        case Some(x) => x.products
        case None => List()
      })

  override def findOneProductById(categoryId: CategoryId, productId: ProductId): Future[entities.Product] =
    database.withCodecRegistry(codecRegistry)
      .getCollection[Category](collectionName)
      .find(and(equal("_id", categoryId.id), equal("product.id", productId.id)))
      .headOption
      .collect({
        case Some(x) => x.products(0)
      })


  override def save(category: Category): Future[Category] =
    database.withCodecRegistry(codecRegistry)
    .getCollection[Category](collectionName)
    .insertOne(category)
    .transform(result => category, error => error)
    .head

  override def nextCategoryId: CategoryId = CategoryId(new ObjectId().toString)
}
