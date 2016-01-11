package com.gif.branch.gifrecord.Utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Size;
import android.view.WindowManager;

import com.gif.branch.gifrecord.ScreenInfo;

/**
 * Created by Branch on 16/1/10.
 */
public class SystemUtil {

  public static ScreenInfo getScreenSize(Context mContext) {

    ScreenInfo info = new ScreenInfo();

    DisplayMetrics metrics = new DisplayMetrics();

    WindowManager windowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
    windowManager.getDefaultDisplay().getMetrics(metrics);
    info.width = metrics.widthPixels;
    info.height = metrics.heightPixels;
    info.density = metrics.density;

    return info;
  }


  /**
   * 获取状态栏的高度
   */
  public static int getStatusHeight(Activity activity) {
    int statusHeight = 0;
    Rect localRect = new Rect();
    activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    statusHeight = localRect.top;
    if (0 == statusHeight) {
      Class<?> localClass;
      try {
        localClass = Class.forName("com.android.internal.R$dimen");
        Object localObject = localClass.newInstance();
        int i5 = Integer.parseInt(localClass.getField("status_bar_height").get(localObject).toString());
        statusHeight = activity.getResources().getDimensionPixelSize(i5);
      } catch (Exception e) {
        e.printStackTrace();
        statusHeight = getStatusHeight2(activity);
      }
    }
    return statusHeight;
  }

  private static int getStatusHeight2(Activity activity) {

    Rect outRect = new Rect();
    activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(outRect);
    int height = getScreenSize(activity).height - outRect.height();

    Log.e("branch", "状态栏高度：->" + height);

    return height;
  }

}
