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
    return r.shuffle(mediaUrl).head
  }

  def getMediaUrls(): List[String] = {
    val mediaUrls: JsResult[MediaUrl] = Json.parse(openJsonFile()).validate[MediaUrl]
    return mediaUrls.get.mediaUrl
  }

  def openJsonFile(): String = {
    val json = FileUtils.readFileToString( new File("../data-warehouse/json/dog-urls.json") )

    return json
  }

}
