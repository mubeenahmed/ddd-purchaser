package product.infrastructure.kakfa

import java.util.Properties

import org.apache.kafka.clients.producer.ProducerConfig
import shared.kakfa.{Producer, Record}
import product.domain.product.entities.Product
import shared.kakfa.ProducerHelper._

trait KafkaProductProducer {
  implicit val record: Record[String, Product] = new Record[String, Product] {
    override def topic: String = "product.create"

    override def key(value: Product): String = value.productId.id

    override def timestamp(value: Product): Long = ???
  }

  val config = new Properties()
  config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9902")

  val productProducer = Producer(config)
  def send(product: Product)  = {
    productProducer.send(product)
    productProducer.close()
  }
}
