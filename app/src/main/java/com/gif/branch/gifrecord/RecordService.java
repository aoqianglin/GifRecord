package com.gif.branch.gifrecord;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by Branch on 16/1/10.
 */
public class RecordService extends IntentService {

  /**
   * Creates an IntentService.  Invoked by your subclass's constructor.
   *
   * @param name Used to name the worker thread, important only for debugging.
   */
  public RecordService(String name) {
    super(name);
  }


  @Override
  protected void onHandleIntent(Intent intent) {

  }


}
