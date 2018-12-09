package product.domain.product.entities

import product.domain.product.valueobjects.{OwnerId, OwnerRating}
import domain.shared.Entity

case class Owner(val ownerId: OwnerId, val ownerRating: OwnerRating) extends Entity[Owner] {
  override def sameIdentityAs(t: Owner): Boolean = t != null && ownerId.sameAsValue(t.ownerId)
}
