package com.ltian.plugins.notification;

import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.util.Key;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.ui.EditorNotificationPanel;
import com.intellij.ui.EditorNotifications;
import com.ltian.plugins.files.MyFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by ltian on 5/23/2017.
 */
public class MyNotificationProvider extends EditorNotifications.Provider<EditorNotificationPanel> implements DumbAware {
    private static final Key<EditorNotificationPanel> KEY = Key.create("My Sample Notification Key");

    private static final String DONT_ASK_TO_CHANGE_PROVIDER_TYPE_KEY = "com.ltian.sample.notifaction.do.not.show.it.again";

    @NotNull
    @Override
    public Key<EditorNotificationPanel> getKey() {
        return KEY;
    }

    @Nullable
    @Override
    public EditorNotificationPanel createNotificationPanel(@NotNull VirtualFile file, @NotNull FileEditor fileEditor) {
        if (file.getFileType() != MyFileType.INSTANCE) {
            return null;
        }

        if (PropertiesComponent.getInstance().getBoolean(DONT_ASK_TO_CHANGE_PROVIDER_TYPE_KEY)) {
            return null;
        }

        final EditorNotificationPanel panel = new EditorNotificationPanel();
        panel.createActionLabel("this is test action", ()-> {

            System.out.println("test Action");
            EditorNotifications.updateAll();
        });

        panel.createActionLabel("Don't show it again", ()-> {
            PropertiesComponent.getInstance().setValue(DONT_ASK_TO_CHANGE_PROVIDER_TYPE_KEY, true);
            EditorNotifications.updateAll();
        });
        return panel;
    }
}
