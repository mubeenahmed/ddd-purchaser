package domain.shared

trait ValueObject[T] {
  def sameAsValue(t: T): Boolean
}
