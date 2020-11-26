package cluster.kmeans

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.mllib.clustering.{KMeans, KMeansModel}
import org.apache.spark.mllib.linalg.Vectors

// https://www.cnblogs.com/yszd/p/10691187.html
object KMeansTest {
//  Logger.getLogger("org").setLevel(Level.WARN)
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("KMeansExample")
    conf.setMaster("local[2]")
    val sc = new SparkContext(conf)

    // Load and parse the data
    val data = sc.textFile("data/mllib/kmeans_data.txt")
    val parsedData = data.map(s => Vectors.dense(s.split(',').map(_.toDouble))).cache()

    // split data to train data and test data
    val weights = Array(0.8, 0.2)
//    val splitParseData = parsedData.randomSplit(weights)

    // Cluster the data into two classes using KMeans
    val numClusters = 2
    val numIterations = 20
    val clusters = KMeans.train(parsedData, numClusters, numIterations)

    // Evaluate clustering by computing Within Set Sum of Squared Errors
    val WSSSE = clusters.computeCost(parsedData)
    println("Within Set Sum of Squared Errors = " + WSSSE)

    // predict data
    val result = clusters.predict(parsedData)
    result.foreach(println(_))

    // Save and load model
    clusters.save(sc, "target/KMeansModel")
    val sameModel = KMeansModel.load(sc, "target/KMeansModel")

    sc.stop()
  }
}
