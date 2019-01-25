package product.infrastructure.kakfa

import java.time.Instant
import java.util.Properties

import com.goyeau.kafka.streams.circe.CirceSerdes
import com.typesafe.config.ConfigFactory
import io.circe._
import org.apache.kafka.clients.producer.ProducerConfig
import shared.kakfa.Record
import product.domain.product.entities.Product
import product.domain.product.valueobjects.ProductId
import shared.kakfa.ProducerHelper._

trait KafkaProductProducer {

  val properties = ConfigFactory.load()
  val productCreateTopic = properties.getString("kafka.product.topic")
  val host = properties.getString("kafka.host")
  val port = properties.getInt("kafka.port")

  implicit val record: Record[ProductId, Product] = new Record[ProductId, Product] {
    override def topic: String = productCreateTopic

    override def key(value: Product): ProductId = value.productId

    override def timestamp(value: Product): Long = Instant.EPOCH.getEpochSecond
  }

  implicit val encodeProduct: Encoder[Product]
  implicit val encodeProductId: Encoder[ProductId]

  implicit val valueSerializer = CirceSerdes.serializer[Product]
  implicit val keySerializer = CirceSerdes.serializer[ProductId]

  val config = new Properties()
  config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, s"$host:$port")


  val productProducer = shared.kakfa.Producer[Product](config)
  def send(product: Product)  = {
    productProducer.send(product)
    productProducer.close()
  }
}
