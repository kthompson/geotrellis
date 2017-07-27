package geotrellis.spark.pipeline.eval.ast.multiband.spatial

import io.circe.syntax._

import geotrellis.raster._
import geotrellis.spark.pipeline.eval.ast._
import geotrellis.spark.pipeline.json.transform
import geotrellis.vector._

import org.apache.spark.rdd.RDD

case class PerTileReproject(
  node: Node[RDD[(ProjectedExtent, MultibandTile)]],
  arg: transform.PerTileReproject
) extends Transform[RDD[(ProjectedExtent, MultibandTile)], RDD[(ProjectedExtent, MultibandTile)]] {
  def asJson = node.asJson :+ arg.asJson
}