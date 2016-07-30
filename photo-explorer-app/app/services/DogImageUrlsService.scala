package services

import java.io.File

import org.apache.commons.io.FileUtils

/**
  * Created by Sa2 on 2016/06/05.
  */
class DogImageUrlsService extends ImageUrlsService {

  override def openJsonFile(): String = FileUtils.readFileToString( new File("/tmp/photo-explorer/json/dog-urls.json") )

}
