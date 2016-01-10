package com.gif.branch.gifrecord;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;

import com.gif.branch.gifrecord.endoder.AnimatedGifEncoder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends BaseActivity {

  private int width = 480;
  private int height = 720;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    String path= Environment.getExternalStorageDirectory().getAbsolutePath()+"/gif.gif";

    FileOutputStream outputStream=null;
    try {
      File f=new File(path);
      if(!f.exists()){
        f.createNewFile();
      }
       outputStream=new FileOutputStream(path);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }


    AnimatedGifEncoder animatedGifEncoder = new AnimatedGifEncoder();

    animatedGifEncoder.start(outputStream);
    animatedGifEncoder.setRepeat(0);
    animatedGifEncoder.setFrameRate(60);
    animatedGifEncoder.setQuality(15);

    animatedGifEncoder.addFrame(decodeBitmap(R.mipmap.girl_1));
    animatedGifEncoder.addFrame(decodeBitmap(R.mipmap.girl_2));
    animatedGifEncoder.addFrame(decodeBitmap(R.mipmap.girl_3));

    animatedGifEncoder.finish();

  }

  private Bitmap decodeBitmap(int resId){

    Bitmap b = null;
    BitmapFactory.Options options = new BitmapFactory.Options();
    options.inJustDecodeBounds = true;
    BitmapFactory.decodeResource(getResources(), R.mipmap.girl_1);
    if (options.outWidth > 0 && options.outHeight > 0) {
      options.inSampleSize = (options.outWidth / width + options.outHeight / height) / 2;
    }
    options.inJustDecodeBounds=false;

    b=BitmapFactory.decodeResource(getResources(),resId,options);

    return b;
  }


  public void onMainBtnClick(View v){
    switch (v.getId()){
      case R.id.main_start_record_gif_tv:

        break;
      case R.id.main_open_record_gif_tv:

        break;

    }

  }


}
