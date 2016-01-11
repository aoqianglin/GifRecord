package com.gif.branch.gifrecord;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Branch on 16/1/11.
 */
public class RecordActivity extends BaseActivity {

  public static Intent newIntent(Context mContext) {
    Intent intent = new Intent(mContext, RecordActivity.class);

    return intent;
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(new View(getApplicationContext()));

    startService();

  }


  private void startService(){
    Intent service=new Intent();
    service.setClass(this,RecordService.class);
    startService(service);
  }

}
