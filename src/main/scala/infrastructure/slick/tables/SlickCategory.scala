package infrastructure.slick.tables


import slick.jdbc.H2Profile.api._
import slick.lifted._

import scala.concurrent.ExecutionContext.Implicits.global


class SlickCategory(tag: Tag) extends Table[(Int ,String, Int)](tag, "category")
{
  def id = column[Int]("id", O.PrimaryKey)
  def name = column[String]("category_name")
  def parentId = column[Int]("parent_id")

  override def * = (id,name, parentId)
}
