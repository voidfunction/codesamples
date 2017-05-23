package com.ltian.plugins.configuration;

import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SearchableConfigurable;
import com.ltian.plugins.MyApplicationService;
import com.ltian.plugins.MyBundle;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Created by ltian on 5/23/2017.
 */
public class MyApplicationConfigurable implements SearchableConfigurable {

    private MyApplicationService mySettings;

    public MyApplicationConfigurable(@NotNull MyApplicationService settings) {
        mySettings = settings;
    }

    @NotNull
    @Override
    public String getId() {
        return "settings.my.samples.id";
    }

    @Nls
    @Override
    public String getDisplayName() {
        return MyBundle.message("my.application.configuration.name");
    }

    @Nullable
    @Override
    public String getHelpTopic() {
        return null;
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        return new JButton("test Button");
    }

    @Override
    public boolean isModified() {
        return false;
    }

    @Override
    public void apply() throws ConfigurationException {

    }
}
