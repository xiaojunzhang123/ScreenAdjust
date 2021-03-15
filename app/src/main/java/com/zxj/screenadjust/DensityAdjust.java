package com.zxj.screenadjust;

import android.app.Activity;
import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;

public class DensityAdjust {

    private final String design_width_in_dp = "design_width_in_dp";

    private final String design_height_in_dp = "design_height_in_dp";

    private String design_width_in_dp_value = "";
    private String design_width_in_dp_default_value = "360";

    private String design_height_in_dp_value = "";

    private Application application;

    public DensityAdjust(Application application) {
        this.application = application;
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = application.getPackageManager().getApplicationInfo(application.getPackageName(), PackageManager.GET_META_DATA);
            Bundle bundle = applicationInfo.metaData;
            design_width_in_dp_value = bundle.getString(design_width_in_dp, design_width_in_dp_default_value);
            design_height_in_dp_value = bundle.getString(design_height_in_dp, null);
            Log.e("========>111", design_width_in_dp_value);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setDensityInfo(Activity activity) {
        if (TextUtils.isEmpty(design_width_in_dp_value)) {
            throw new RuntimeException("请在 AndroidManifest.xml 文件中设置目标总宽度");
        }
        DisplayMetrics displayMetrics = application.getResources().getDisplayMetrics();
        int designWide = Integer.valueOf(design_width_in_dp_value);
        float targetDensity = displayMetrics.widthPixels / designWide;
        int targetDensityDpi = (int) (targetDensity * 160);
        DisplayMetrics targetDisplayMetrics = activity.getResources().getDisplayMetrics();
        targetDisplayMetrics.density = targetDensity;
        targetDisplayMetrics.densityDpi = targetDensityDpi;
        Log.e("========>222 density", targetDensity + "");
        Log.e("========>222 densityDpi", targetDensityDpi + "");
    }

}
