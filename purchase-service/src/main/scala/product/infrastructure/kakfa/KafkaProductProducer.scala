package product.infrastructure.kakfa

import java.time.Instant
import java.util.Properties

import com.goyeau.kafka.streams.circe.CirceSerdes
//import io.circe._, io.circe.generic.semiauto.{ deriveEncoder }
import io.circe._, io.circe.generic.semiauto._


import org.apache.kafka.clients.producer.ProducerConfig
import shared.kakfa.{Producer, Record}
import product.domain.product.entities.Product
import product.domain.product.valueobjects.ProductId
import shared.kakfa.ProducerHelper._

trait KafkaProductProducer {

  implicit val record: Record[ProductId, Product] = new Record[ProductId, Product] {
    override def topic: String = "product.create"

    override def key(value: Product): ProductId = value.productId

    override def timestamp(value: Product): Long = Instant.EPOCH.getEpochSecond
  }

  implicit val encodeProduct: Encoder[Product] = deriveEncoder[Product]
  implicit val encodeProductId: Encoder[ProductId] = deriveEncoder[ProductId]

  implicit val valueSerializer = CirceSerdes.serializer[Product]
  implicit val keySerializer = CirceSerdes.serializer[ProductId]

  val config = new Properties()
  config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9902")


  val productProducer = shared.kakfa.Producer[Product](config)
  def send(product: Product)  = {
    productProducer.send(product)
    productProducer.close()
  }
}
