package com.gif.branch.gifrecord.Utils;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by Branch on 16/1/10.
 */
public class FileUtil {

  private static final String APP_ROOT_DIR = "GifRecord";

  private static final String APP_FILE_GIF="gif";

  private static final String APP_FILE_IMAGE="image";

  private volatile static FileUtil mInstance;

  public static FileUtil getInstance() {
    if (mInstance == null) {
      synchronized (FileUtil.class) {
        if (mInstance == null) {
          mInstance = new FileUtil();
        }
      }
    }
    return mInstance;
  }


  private FileUtil() {

  }

  public String getCacheDir(Context mContext) {

    String path = null;

    if (Environment.isExternalStorageRemovable()) {
      path = Environment.getDataDirectory() + "/" + mContext.getPackageName() + "/" + APP_ROOT_DIR + "/";
    } else {
      path = Environment.getExternalStorageDirectory() + "/" + APP_ROOT_DIR + "/";
    }
    File f = new File(path);
    if (!f.exists()) {
      f.mkdirs();
    }
    return path;

  }


  public String getGifSavePath(Context mContext,String fileName){

    String path=getCacheDir(mContext);
    path+=APP_FILE_GIF+"/";
    if(TextUtils.isEmpty(fileName)){
      path+=System.currentTimeMillis()+".gif";
    }else if(fileName.endsWith(".gif")){
      path+=fileName;
    }else {
      path+=fileName+".gif";
    }

    File f=new File(path);
    if(!f.exists()){
      try {
        f.createNewFile();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    return path;
  }


}
