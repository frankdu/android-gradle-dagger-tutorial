package com.frankdu.common;

import android.os.Bundle;

import com.actionbarsherlock.app.SherlockFragmentActivity;

import dagger.ObjectGraph;

public abstract class BaseActivity
        extends SherlockFragmentActivity
        implements Injector {

    private ObjectGraph mActivityGraph;

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create the activity graph by .plus-ing our modules onto the application graph.
        DaggerApplication application = (DaggerApplication) getApplication();
        mActivityGraph = application.getObjectGraph().plus(geActivitytModules());

        // Inject ourselves so subclasses will have dependencies fulfilled when this method returns.
        mActivityGraph.inject(this);
    }

    @Override
    protected void onDestroy() {
        // Eagerly clear the reference to the activity graph to allow it to be garbage collected as
        // soon as possible.
        mActivityGraph = null;

        super.onDestroy();
    }

    protected <T> T getView(int id) {
        return (T) findViewById(id);
    }

    /**
     * Inject the supplied {@code object} using the activity-specific graph.
     * */
    @Override
    public void inject(Object object) {
        mActivityGraph.inject(object);
    }

    public ObjectGraph getObjectGraph() {
        return mActivityGraph;
    }

    protected abstract Object[] geActivitytModules();
}