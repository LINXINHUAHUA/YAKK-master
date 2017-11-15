import android.app.Application;

import org.litepal.LitePal;

/**
 * Created by baolei on 2017/10/2.
 */

public class MyApplication extends Application {

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        LitePal.initialize(this);//数据库
    }
}
