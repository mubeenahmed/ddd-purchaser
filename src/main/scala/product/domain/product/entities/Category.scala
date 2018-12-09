package product.domain.product.entities


import product.domain.product.valueobjects.{CategoryId, CategoryParentId}
import domain.shared.Entity

case class Category(val catId: CategoryId,
                    val products: List[Product],
                    val name: String,
                    val parentId: Option[CategoryParentId])
  extends Entity[Category]
{

  override def sameIdentityAs(t: Category): Boolean = t != null && catId.sameAsValue(t.catId)

}
