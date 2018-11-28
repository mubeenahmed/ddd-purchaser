package domain.product.entities

import java.util.Optional

import domain.product.valueobjects.{CategoryId, CategoryParentId}
import domain.shared.Entity

case class Category(val productId: CategoryId,
                    val products: List[Product],
                    val name: String,
                    val parentId: Optional[CategoryParentId])
  extends Entity[Category]
{

  override def sameIdentityAs(t: Category): Boolean = t != null && productId.sameAsValue(t.productId)

}
