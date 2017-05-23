package com.ltian.plugins;

import com.intellij.openapi.components.ApplicationComponent;
import org.jetbrains.annotations.NotNull;

/**
 * Created by ltian on 5/22/2017.
 */
public class MyApplicationComponent implements ApplicationComponent {
    @Override
    public void initComponent() {

    }

    @Override
    public void disposeComponent() {

    }

    @NotNull
    @Override
    public String getComponentName() {
        return MyApplicationComponent.class.getCanonicalName();
    }
}
