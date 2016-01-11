package com.gif.branch.gifrecord.Utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;

/**
 * Created by Branch on 16/1/10.
 */
public class BitmapUtil {

  /**
   * Returns a bitmap showing a screenshot of the view passed in.
   */
  public static Bitmap getBitmapFromView(View fromView) {

    if (fromView == null || fromView.getWidth() == 0 || fromView.getHeight() == 0) {
      return null;
    }
    Bitmap bitmap = Bitmap.createBitmap(fromView.getWidth(), fromView.getHeight(), Bitmap.Config.ARGB_4444);
    Canvas canvas = new Canvas(bitmap);
    fromView.draw(canvas);
    return bitmap;
  }

}
