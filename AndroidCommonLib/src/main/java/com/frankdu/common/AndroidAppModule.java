package com.frankdu.common;

import android.content.Context;
import android.location.LocationManager;

import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
        complete = false,
        library = true,
        injects = {
        }
)
public class AndroidAppModule {

    /* package */ static Context sApplicationContext = null;

    /**
     * Allow the application context to be injected but require that it be annotated with
     * {@link com.frankdu.common.ForApplication @Annotation} to explicitly differentiate it from an activity context.
     */
    @Provides
    @Singleton
    @ForApplication
    Context provideApplicationContext() {
        return sApplicationContext;
    }

    @Provides @Singleton
    LocationManager provideLocationManager() {
        return (LocationManager) sApplicationContext.getSystemService(Context.LOCATION_SERVICE);
    }

    @Provides @Singleton
    Bus provideBus() {
        return new Bus();
    }
}