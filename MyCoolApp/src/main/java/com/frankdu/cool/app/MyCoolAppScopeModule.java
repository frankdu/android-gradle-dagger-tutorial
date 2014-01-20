package com.frankdu.cool.app;

import android.content.Context;

import com.frankdu.common.AndroidAppModule;
import com.frankdu.common.ForApplication;
import com.frankdu.cool.BuildConfig;
import com.frankdu.cool.annotations.FacebookApiKey;
import com.frankdu.cool.annotations.FacebookApiSecret;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;

/**
 * Here it provides the dependencies those are used in the whole scope of your MyCoolApp
 */
@Module(
        complete = true,    // Here it enables object graph validation
        library = true,
        addsTo = AndroidAppModule.class, // Important for object graph validation at compile time
        injects = {
                MyCoolApplication.class,
        }
)
public class MyCoolAppScopeModule {

    @Provides @FacebookApiKey
    String providesFacebookApiKey() {
        // Create your Facebook App at https://developers.facebook.com/apps
        return "Injected: your-fb-api-key";
    }

    @Provides @FacebookApiSecret
    String providesFacebookApiSecret() {
        // Create your Facebook App at https://developers.facebook.com/apps
        return "Injected: your-fb-api-secret";
    }

    @Provides
    Picasso providesPicasso(@ForApplication Context context) {
        Picasso picasso = Picasso.with(context);

        // some app-wide common settings
        picasso.setDebugging(BuildConfig.DEBUG);

        return picasso;
    }
}
