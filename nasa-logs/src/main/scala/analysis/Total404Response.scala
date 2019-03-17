package data.analysis

import java.io.File

import data.DataCleaner.Log
import org.apache.hadoop.fs.FileUtil
import org.apache.spark.sql.DataFrame


class HTTPStatus(dataFrame: DataFrame) extends Analyzable {

  private val file = "result_data/_http_status.json"
  private val destinationFile= "result_data/http_status.json"

  override def analyzeAndGenFile: Unit = {

    FileUtil.fullyDelete(new File(file))
    FileUtil.fullyDelete(new File(destinationFile))

    dataFrame
      .groupBy(Log.STATUS => 404)
      .count()
      .sort(Log.STATUS => 404)
      .write
      .json(file)

    merge(file, destinationFile)

    FileUtil.fullyDelete(new File(file))
  }

  override def generatePlotFile: Unit = ???
}

object HTTPStatus {
  def apply(dataFrame: DataFrame): Unit = new HTTPStatus(dataFrame).analyzeAndGenFile
}