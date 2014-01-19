package com.frankdu.cool.app;

import com.frankdu.common.DaggerApplication;

import java.util.Collections;
import java.util.List;

public class MyCoolApplication extends DaggerApplication {

    @Override
    protected List<Object> getAppModules() {
        return Collections.<Object>singletonList(new MyCoolAppScopeModule());
    }
}