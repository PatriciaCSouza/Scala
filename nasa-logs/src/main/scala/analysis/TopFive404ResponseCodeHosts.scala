package data.analysis

import org.apache.spark.sql.DataFrame

class TopFive404ResponseCodeHosts(dataFrame: DataFrame) extends Analyzable {
  override def analyzeAndGenFile: Unit = ???

  override def generatePlotFile: Unit = ???
}