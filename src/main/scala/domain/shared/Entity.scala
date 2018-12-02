package domain.shared

trait Entity[T] {
  val id: T
  def sameIdentityAs(t: T): Boolean
}
