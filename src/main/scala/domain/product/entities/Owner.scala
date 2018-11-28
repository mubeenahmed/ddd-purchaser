package domain.product.entities

import domain.product.valueobjects.OwnerId
import domain.shared.Entity

case class Owner(val ownerId: OwnerId, val ownerRating: OwnerRating) extends Entity[Owner] {
  override def sameIdentityAs(t: Owner): Boolean = t != null && ownerId.sameAsValue(t.ownerId)
}
