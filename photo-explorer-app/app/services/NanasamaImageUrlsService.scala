package services

import java.io.File

import org.apache.commons.io.FileUtils

/**
  * Created by Sa2 on 2016/07/09.
  */
class NanasamaImageUrlsService extends ImageUrlsService {

  override def openJsonFile(): String = FileUtils.readFileToString( new File("/tmp/photo-explorer/json/nanasama-urls.json") )

}
