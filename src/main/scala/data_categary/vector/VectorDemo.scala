package data_categary.vector

import org.apache.spark.mllib.linalg.{Vector, Vectors}

// https://www.cnblogs.com/swordfall/p/9456222.html
object VectorDemo {

  def main(args: Array[String]): Unit = {
    // 创建密集向量(1.0, 0.0, 3.0)
    val dv: Vector = Vectors.dense(1.0, 0.0, 3.0)
    // 给向量(1.0, 0.0, 3.0)创建疏向量
    val svl: Vector= Vectors.sparse(3, Array(0, 2), Array(1.0, 3.0))
    // 通过指定非0的项目，创建稀疏向量(1.0, 0.0, 3.0)
    val sv2: Vector = Vectors.sparse(3, Seq((0, 1.0), (2, 3.0)))

    println(svl)
  }

}
