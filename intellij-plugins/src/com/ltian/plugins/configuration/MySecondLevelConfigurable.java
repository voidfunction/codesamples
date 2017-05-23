package com.ltian.plugins.configuration;

import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SearchableConfigurable;
import com.ltian.plugins.MyBundle;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Created by ltian on 5/23/2017.
 */
public class MySecondLevelConfigurable implements SearchableConfigurable {
    @NotNull
    @Override
    public String getId() {
        return "my.application.second.configuration.id";
    }

    @Nls
    @Override
    public String getDisplayName() {
        return MyBundle.message("my.application.second.configuration.name");
    }

    @Nullable
    @Override
    public String getHelpTopic() {
        return null;
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        return new JButton("Test button");
    }

    @Override
    public boolean isModified() {
        return false;
    }

    // save configuration
    @Override
    public void apply() throws ConfigurationException {

        int a   = 1;
    }
}
