package com.zxj.screenadjust;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ScreenAdjust implements Application.ActivityLifecycleCallbacks {

    private static volatile ScreenAdjust screenAdjust;
    private DensityAdjust densityAdjust;

    private ScreenAdjust() {
    }

    public static ScreenAdjust getInstance() {
        if (screenAdjust == null) {
            synchronized (ScreenAdjust.class) {
                if (screenAdjust == null) {
                    screenAdjust = new ScreenAdjust();
                }
            }
        }
        return screenAdjust;
    }

    public void init(final Application application) {
        densityAdjust = new DensityAdjust(application);
        application.registerActivityLifecycleCallbacks(this);
    }

    @Override
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {
        densityAdjust.setDensityInfo(activity);
    }

    @Override
    public void onActivityStarted(@NonNull Activity activity) {

    }

    @Override
    public void onActivityResumed(@NonNull Activity activity) {

    }

    @Override
    public void onActivityPaused(@NonNull Activity activity) {

    }

    @Override
    public void onActivityStopped(@NonNull Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(@NonNull Activity activity) {

    }
}
