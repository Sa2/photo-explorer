package models

import play.api.libs.json.Json

/**
  * Created by Sa2 on 2016/06/05.
  */
case class MediaUrl(mediaUrl: List[String])

object MediaUrl {
  implicit def jsonWrites = Json.writes[MediaUrl]
  implicit def jsonReads = Json.reads[MediaUrl]
}