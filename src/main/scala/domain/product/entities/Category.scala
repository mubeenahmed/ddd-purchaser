package domain.product.entities


import domain.product.valueobjects.{CategoryId, CategoryParentId}
import domain.shared.Entity

case class Category(val id: CategoryId,
                    val products: List[Product],
                    val name: String,
                    val parentId: Option[CategoryParentId])
  extends Entity[CategoryId]
{

  override def sameIdentityAs(t: CategoryId): Boolean = t != null && id.sameAsValue(t)

}
