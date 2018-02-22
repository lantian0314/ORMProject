package orm.ormproject;

import android.app.Application;

import com.orm.SugarContext;

/**
 * Created by xingyatong on 2018/2/22.
 */
public class MyApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        SugarContext.init(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        SugarContext.terminate();
    }
}
