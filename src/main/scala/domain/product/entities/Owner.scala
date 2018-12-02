package domain.product.entities

import domain.product.valueobjects.{OwnerId, OwnerRating}
import domain.shared.Entity

case class Owner(val id: OwnerId, val ownerRating: OwnerRating) extends Entity[OwnerId] {
  override def sameIdentityAs(t: OwnerId): Boolean = t != null && id.sameAsValue(t)
}
