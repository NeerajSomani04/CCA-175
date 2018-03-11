Some other spark notes:--
 1) very good example for flatMap and map using together and usage of case statement.
 
val grouped = sc.parallelize(Seq(((1,"two"), List((3,4), (5,6)))))
below is result of above command:
scala> grouped
res15: org.apache.spark.rdd.RDD[((Int, String), List[(Int, Int)])] = ParallelCollectionRDD[0] at parallelize at <console>:27

val flattened = grouped.flatMap { case (key, groupValues) => groupValues.map { value => (key._1, key._2, value._1, value._2) } 
result of above command:
scala> flattened
res16: org.apache.spark.rdd.RDD[(Int, String, Int, Int)] = MapPartitionsRDD[1] at flatMap at <console>:29

Problem 1:-


