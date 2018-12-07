package infrastructure.mongo

import com.mongodb.ServerAddress
import org.mongodb.scala._

import scala.collection.JavaConverters._

trait MongoDbConfiguration {

  // or provide custom MongoClientSettings
  val settings: MongoClientSettings = MongoClientSettings.builder()
    .applyToClusterSettings(b => b.hosts(List(new ServerAddress("localhost")).asJava)).build()

  val mongoClient: MongoClient = MongoClient(settings)

  val database: MongoDatabase = mongoClient.getDatabase("purchaser")
}
