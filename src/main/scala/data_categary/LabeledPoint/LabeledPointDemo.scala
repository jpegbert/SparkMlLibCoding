package data_categary.LabeledPoint

import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.LabeledPoint

// https://www.cnblogs.com/swordfall/p/9456222.html
object LabeledPointDemo {

  def main(args: Array[String]): Unit = {
    // 使用标签1.0和一个密集向量创建一个标记点
    val pos = LabeledPoint(1.0, Vectors.dense(1.0, 0.0, 3.0))
    // 使用标签0.0和一个疏向量创建一个标记点
    val neg = LabeledPoint(0.0, Vectors.sparse(3, Array(0, 2), Array(1.0, 3.0)))
  }

}
