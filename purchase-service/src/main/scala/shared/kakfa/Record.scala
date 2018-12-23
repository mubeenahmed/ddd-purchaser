package shared.kakfa

trait Record[K, V] {
  def topic: String
  def key(value: V): K
  def timestamp(value: V): Long
}
