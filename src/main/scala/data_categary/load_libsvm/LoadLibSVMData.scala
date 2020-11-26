package data_categary.load_libsvm

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.rdd.RDD

/**
  * SparkMlLib 加载libsvm格式数据集
  * libsvm格式数据形态：label index1:value1 index2:value2 ...
  */
object LoadLibSVMData {

  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("svm")
    val sc = new SparkContext(conf)
    val examples: RDD[LabeledPoint] = MLUtils.loadLibSVMFile(sc, "data/sample_libsvm_data.txt")
  }

}
