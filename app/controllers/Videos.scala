package controllers


import play.api.libs.iteratee.Enumerator
import play.api.mvc.{Action, ResponseHeader, Result}
import play.mvc._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future


/**
  * Created by amarjits on 4/14/16.
  */
trait Videos extends Controller{
  def stream(fileName: String) =  Action.async { implicit request =>
    Future {
      //video files stored locally in 'videos' folder in order to use it on production mode also

      val file = new java.io.File(fileName)
      val fileContent: Enumerator[Array[Byte]] = Enumerator.fromFile(file)
      Result(
        ResponseHeader(200),
        body = fileContent
      )
    }
  }



}
object Videos extends Videos