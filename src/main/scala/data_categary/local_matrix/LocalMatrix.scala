package data_categary.local_matrix

import org.apache.spark.mllib.linalg.{Matrix, Matrices}

/**
  * 局部矩阵
  *
  * 对于矩阵((1.0，2.0),(3.0, 4.0),(5.0, 6.0)), 在SparkMlLib中是存储到一维数组[1.0, 3.0, 5.0, 2.0, 4.0, 6.0]，这个矩阵的尺寸是3*2，即3行2列。
  *
  * 局部矩阵的基类是Matrix，目前有一个实现类DenseMatrix。Spark官方推荐使用Matrices中实现的工厂方法创建局部矩阵
  */

object LocalMatrix {

  def main(args: Array[String]): Unit = {
    //创建密矩阵((1.0，2.0),(3.0, 4.0),(5.0, 6.0))
    val dm: Matrix = Matrices.dense(3, 2, Array(1.0, 3.0, 5.0, 2.0, 4.0, 6.0))
  }

}
