package com.gif.branch.gifrecord;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

/**
 * Created by Branch on 16/1/10.
 */
public class RecordService extends IntentService {


  private WindowManager mWindowManager;


  private View mFloatView;
  private TextView mFloatTimeTv;
  private TextView mFloatStopBtnTv;

  public RecordService() {
    super("RecordService");
  }

  public RecordService(String name) {
    super(name);
  }

  @Override
  public void onCreate() {
    super.onCreate();
    makeGifTitle();
  }


  private void makeGifTitle() {
    mWindowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
    WindowManager.LayoutParams params = new WindowManager.LayoutParams(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, PixelFormat.RGBA_8888);
    params.gravity = Gravity.TOP;
    params.x = 0;
    params.y = 0;
    params.width = WindowManager.LayoutParams.MATCH_PARENT;
    params.height = GifConst.mStatusHeight;


    ensureFloatView();

    mWindowManager.addView(mFloatView, params);


  }

  private void ensureFloatView() {
    mFloatView = LayoutInflater.from(this).inflate(R.layout.record_title_layout, null);
    mFloatTimeTv = (TextView) mFloatView.findViewById(R.id.record_tip_and_time);
    mFloatStopBtnTv = (TextView) mFloatView.findViewById(R.id.record_stop_btn_tv);
  }


  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {
    return super.onStartCommand(intent, flags, startId);
  }

  @Override
  protected void onHandleIntent(Intent intent) {

  }


  @Override
  public void onDestroy() {
    super.onDestroy();
  }
}
