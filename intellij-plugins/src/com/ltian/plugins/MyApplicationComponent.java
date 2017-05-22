package com.ltian.plugins;

import com.intellij.configurationStore.ApplicationStorageManager;
import com.intellij.ide.ApplicationActivationStateManager;
import com.intellij.ide.plugins.PluginManager;
import com.intellij.notification.NotificationsManager;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.compiler.CompilerManager;
import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.project.ProjectUtil;
import com.intellij.util.PlatformUtils;
import com.intellij.util.ui.PlatformColors;
import org.jetbrains.annotations.NotNull;

/**
 * Created by ltian on 5/22/2017.
 */
public class MyApplicationComponent implements ApplicationComponent {
    @Override
    public void initComponent() {
        PluginManager pluginManager;
        ActionManager actionManager;
        CompilerManager compilerManager;
        NotificationsManager notificationsManager;
        ApplicationManager applicationManager;
        ApplicationStorageManager applicationStorageManager;
        ApplicationActivationStateManager applicationActivationStateManager;
        ProjectManager projectManager;
        ProjectUtil.guessProjectForFile(null);
        com.intellij.openapi.application.PathManager pathManager;
        com.intellij.openapi.application.PluginPathManager pluginPathManager;
        com.intellij.openapi.components.ServiceManager serviceManager;
        com.intellij.openapi.components.StoragePathMacros storagePathMacros; // path types
        PlatformUtils.isPyCharm(); // get IDE type
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
