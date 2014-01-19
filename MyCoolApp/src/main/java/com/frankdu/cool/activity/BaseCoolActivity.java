package com.frankdu.cool.activity;

import com.frankdu.common.BaseActivity;

public abstract class BaseCoolActivity extends BaseActivity {
    @Override
    protected Object[] geActivitytModules() {
        return new Object[] {
                new ActivityScopeModule(this),
                // new AnotherCoolActivityScopedModule(),
        };
    }
}
