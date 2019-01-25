package product.infrastructure.mongo

import com.mongodb.ServerAddress
import com.typesafe.config.ConfigFactory
import org.mongodb.scala._

import scala.collection.JavaConverters._

trait MongoDbConfiguration {

  val config = ConfigFactory.load()
  val host = config.getString("mongodb.host")
  val dbName = config.getString("mongodb.database")

  // or provide custom MongoClientSettings
  val settings: MongoClientSettings = MongoClientSettings.builder()
    .applyToClusterSettings(b => b.hosts(List(new ServerAddress(host)).asJava)).build()

  val mongoClient: MongoClient = MongoClient(settings)

  val database: MongoDatabase = mongoClient.getDatabase(dbName)
}
