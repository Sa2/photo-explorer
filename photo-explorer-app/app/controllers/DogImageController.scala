package controllers

import com.google.inject.Inject
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}
import services.ImageUrlsService

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by Sa2 on 2016/06/05.
  */
class DogImageController @Inject()(val imageUrlsService: ImageUrlsService) extends Controller {

  def imageRedirect = Action.async { implicit rs =>
    Future {
      Redirect(imageUrlsService.getRandomPicUrl(), 302)
    }
  }

  def sendRawUrl = Action.async { implicit rs =>
    Future {
      Ok(imageUrlsService.getRandomPicUrl())
    }
  }

  def sendXml = Action.async { implicit rs =>
    Future {
      Ok(<response>
        <data>
          <images>
            <image>
              <url>
                {imageUrlsService.getRandomPicUrl()}
              </url>
            </image>
          </images>
        </data>
      </response>)
    }
  }

  def sendJson = Action.async { implicit rs =>
    Future {
      Ok(Json.obj("url" -> imageUrlsService.getRandomPicUrl()))
    }
  }
}
