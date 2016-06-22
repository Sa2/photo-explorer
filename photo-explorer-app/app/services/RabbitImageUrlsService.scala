package services

import java.io.File

import org.apache.commons.io.FileUtils

/**
  * Created by Sa2 on 2016/06/19.
  */
class RabbitImageUrlsService extends ImageUrlsService {

  override def openJsonFile(): String = {
    val json = FileUtils.readFileToString( new File("../../../data-warehouse/json/rabbit-urls.json") )

    return json
  }
}