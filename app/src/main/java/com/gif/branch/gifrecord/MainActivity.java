package com.gif.branch.gifrecord;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;

import com.gif.branch.gifrecord.Utils.SystemUtil;
import com.gif.branch.gifrecord.endoder.AnimatedGifEncoder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends BaseActivity {


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


  }

  @Override
  public void onWindowFocusChanged(boolean hasFocus) {
    super.onWindowFocusChanged(hasFocus);

    initScreen();
  }

  private void initScreen() {
    ScreenInfo info = SystemUtil.getScreenSize(this);
    int statusHeight = SystemUtil.getStatusHeight(this);

    GifConst.mWidth = info.width;
    GifConst.mHeight = info.height;
    GifConst.mDensity = info.density;
    GifConst.mStatusHeight = statusHeight;

    Log.e("branch", "width: " + GifConst.mWidth + "  height: " + GifConst.mHeight + " statusHeight: " + GifConst.mStatusHeight + " mDensity: " + GifConst.mDensity);
  }


  public void onMainBtnClick(View v) {
    switch (v.getId()) {
      case R.id.main_start_record_gif_tv:
        startActivity(RecordActivity.newIntent(this));

        break;
      case R.id.main_open_record_gif_tv:

        break;
      case R.id.main_make_record_gif_tv:

        break;

    }

  }


}
