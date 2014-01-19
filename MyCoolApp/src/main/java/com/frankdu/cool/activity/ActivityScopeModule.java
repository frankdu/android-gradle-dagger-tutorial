package com.frankdu.cool.activity;

import android.app.Activity;
import android.content.Context;

import com.frankdu.common.ForActivity;
import com.frankdu.cool.app.MyCoolAppScopeModule;
import com.frankdu.cool.fragment.IntroFragment;
import com.frankdu.cool.fragment.PictureFragment;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Here it provides the dependencies those have same lifetime of one activity in your MyCoolApp
 */
@Module(
        complete = true,
        library = true,
        addsTo = MyCoolAppScopeModule.class, // Important for object graph validation at compile time
        injects = {
                SplashActivity.class,
                // DeviceLocationService.class,
                MainCoolActivity.class,
                IntroFragment.class,
                PictureFragment.class,
        }
)
public class ActivityScopeModule {

    private final BaseCoolActivity mActivity;

    public ActivityScopeModule(BaseCoolActivity activity) {
        mActivity = activity;
    }

    @Provides
    @Singleton
    @ForActivity
    Context providesActivityContext() {
        return mActivity;
    }

    @Provides
    @Singleton
    Activity providesActivity() {
        return mActivity;
    }
}
