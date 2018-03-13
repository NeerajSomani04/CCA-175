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

2) Hive import and avro file format 
sqoop and hive import tutorial --> http://www.itversity.com/topic/creating-tables-in-hiveimpala/   

Example for creating hive tables with different names than column names in avsc files

CREATE TABLE orders_part_avro (
order_id int,
order_date bigint,
order_customer_id int,
order_status string
)
PARTITIONED BY (order_month string)
STORED AS AVRO
LOCATION 'hdfs:///user/cloudera/sqoop_import/orders_part_avro'
TBLPROPERTIES ('avro.schema.url'='hdfs://quickstart.cloudera/user/cloudera/avsc_files/orders_part_avro.avsc');


-----------------------------
// Import Spark SQL data types
import org.apache.spark.sql.types.{StructType,StructField,StringType};

// Generate the schema based on the string of schema
val schema =
  StructType(
    schemaString.split(" ").map(fieldName => StructField(fieldName, StringType, true)))
               
// Apply the schema to the RDD.
val peopleDataFrame = sqlContext.createDataFrame(rowRDD, schema)

--------------------------------

               
