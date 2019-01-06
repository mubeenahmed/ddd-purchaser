package shared.kakfa

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord, RecordMetadata}

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object ProducerHelper
{
  implicit class KafkaProducerOps[K, V](kafkaProducer: KafkaProducer[K, V]) {
    def send(value: V)(implicit record: Record[K, V]): Future[RecordMetadata] = Future {
      kafkaProducer.send(new ProducerRecord(record.topic, null, record.timestamp(value), record.key(value), value))
        .get()
    }
  }
}
