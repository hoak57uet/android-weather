package com.gem.weather.utility;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.gem.weather.R;

/**
 * Created by HoaPham on 5/3/18.
 */

public class AlertDialogUtils {
  public static void showError(Context context, String message) {
    new AlertDialog.Builder(context)
        .setTitle(context.getString(R.string.error_title_dialog))
        .setMessage(message)
        .setCancelable(false)
        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
          }
        }).show();
  }
}
