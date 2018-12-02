package infrastructure.slick.tables

import slick.lifted.Tag
import slick.model.Table

class Product(tag: Tag) extends Table[(Int, String,Double, Double, Int)](tag, "product")
{
  def id = columns[Int]("id", O.PrimaryKey)
}
