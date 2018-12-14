package order.infrastructure.table

import java.time.LocalDateTime

trait BaseTable {
  def createdAt : LocalDateTime
}
