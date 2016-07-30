package services

import java.io.File

import models.MediaUrl
import org.apache.commons.io.FileUtils
import play.api.libs.json.{JsResult, Json}

import scala.util.Random

/**
  * Created by Sa2 on 2016/06/19.
  */
class ImageUrlsService {

  def getRandomPicUrl(): String = {
    val r = new Random()
    val mediaUrl: List[String] = getMediaUrls()
    r.shuffle(mediaUrl).head
  }

  def getMediaUrls(): List[String] = {
    val mediaUrls: JsResult[MediaUrl] = Json.parse(openJsonFile()).validate[MediaUrl]
    mediaUrls.get.mediaUrl
  }

  def openJsonFile(): String = {
    FileUtils.readFileToString( new File("/tmp/photo-explorer/json/dog-urls.json"))
  }

}
