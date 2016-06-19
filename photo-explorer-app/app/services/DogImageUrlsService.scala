package services

import java.io.File

import org.apache.commons.io.FileUtils

/**
  * Created by Sa2 on 2016/06/05.
  */
class DogImageUrlsService extends ImageUrlsService {

  override def openJsonFile(): String = {
    val json = FileUtils.readFileToString( new File("../../../data-warehouse/json/dog-urls.json") )

    return json
  }
}
