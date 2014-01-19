package com.frankdu.common;

import dagger.ObjectGraph;

/**
 * An instance which is capable of injecting dependencies.
 */
public interface Injector {
    /**
     * Inject to <code>object</code>
     * @param object
     */
    void inject(Object object);

    ObjectGraph getObjectGraph();
}