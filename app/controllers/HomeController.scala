package controllers

import java.io.File

import play.Play
import play.api.mvc._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */

trait HomeController  extends Controller {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index = Action.async { implicit request =>
    Future {
      val fileList:Array[String] = {
        (new File(Play.application.configuration.getString("baseDir")).listFiles.filter(_.isFile).map(_.getAbsolutePath))
      }

      Ok(views.html.index(fileList))
    }
  }

  def f3 = Action.async { implicit request =>
    Future {
      Ok(views.html.playvideo("My Title"))
    }
  }


}
object HomeController extends HomeController

