package services

import java.io.File

import org.apache.commons.io.FileUtils

/**
  * Created by Sa2 on 2016/07/09.
  */
class NanasamaImageUrlsService extends ImageUrlsService {

  override def openJsonFile(): String = {
    val json = FileUtils.readFileToString( new File("../data-warehouse/json/nanasama-urls.json") )

    return json
  }
}
