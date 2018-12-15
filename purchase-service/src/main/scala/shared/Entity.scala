package shared

trait Entity[T] {
  def sameIdentityAs(t: T): Boolean
}
