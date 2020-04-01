package com.wangshaogang.android03;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 王少刚 on 2018/10/30.
 */

public class ActivityCollector {
    public static List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    public static void finishAll() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();;
            }
        }
        activities.clear();
    }
}
