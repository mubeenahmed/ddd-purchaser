package infrastructure.mongo

import domain.product.entities
import domain.product.entities.Category
import domain.product.repositories.CategoryRepository
import domain.product.valueobjects.{CategoryId, ProductId}
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
      .find.toFuture

  override def findAllProductsByCategoryId(categoryId: CategoryId): Future[Seq[entities.Product]] =
    database.withCodecRegistry(codecRegistry)
      .getCollection[Category](collectionName)
      .find(equal("_id", categoryId.id))
      .head
      .map(_.products)

  override def findOneProductById(categoryId: CategoryId, productId: ProductId): Future[entities.Product] =
    database.withCodecRegistry(codecRegistry)
      .getCollection[Category](collectionName)
      .find(and(equal("_id", categoryId.id), equal("product.id", productId.id)))
      .map(_.products.head)
      .head

  override def save(category: Category): Future[Category] =
    database.withCodecRegistry(codecRegistry)
    .getCollection[Category](collectionName)
    .insertOne(category)
    .transform(result => category, error => error)
    .head

  override def nextCategoryId: CategoryId = CategoryId(new ObjectId().toString)
}
