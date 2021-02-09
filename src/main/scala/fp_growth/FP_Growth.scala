package fp_growth

import org.apache.spark.mllib.fpm.FPGrowth
import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}

/**
  * 有报错，待调试
  */
object FP_Growth {

  def main(args: Array[String]): Unit = {
    val appName = "FP-Growth关联规则"
    val sparkConfig = new SparkConf().setAppName(appName).setMaster("local[*]")
    val spark: SparkSession = SparkSession.builder().config(sparkConfig).getOrCreate()
    var sqlContext = spark.sqlContext
    //调整开发输出的日志信息
    val sc = spark.sparkContext
    sc.setLogLevel("ERROR")

    import spark.implicits._
    val dataList: List[(String)] = List(
      ("A,B,E"),
      ("B,D"),
      ("B,C"),
      ("A,B,D"),
      ("A,C"),
      ("B,C"),
      ("A,C"),
      ("A,B,C,E"),
      ("A,B,C")
    )
    val data = dataList.map(t => t.split(",")).toDF("items")

    val fpgrowth = new FPGrowth().setItemsCol("items").setMinSupport(0.2).setMinConfidence(0.5)
    val model = fpgrowth.fit(data)

    // Display frequent itemsets.
    model.freqItemsets.show()

    // Display generated association rules.
    model.associationRules.show()

    // transform examines the input items against all the association rules and summarize the
    // consequents as prediction
    model.transform(data).show()
  }

}
