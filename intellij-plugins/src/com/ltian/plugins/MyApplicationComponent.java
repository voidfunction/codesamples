package com.ltian.plugins;

import com.intellij.mock.MockVirtualFile;
import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.ProjectManager;
import org.jetbrains.annotations.NotNull;

/**
 * Created by ltian on 5/22/2017.
 */
public class MyApplicationComponent implements ApplicationComponent {
    @Override
    public void initComponent() {
        MockVirtualFile mockVirtualFile = new MockVirtualFile("a.test");
//        FileEditorManager.getInstance(ProjectManager.getInstance().getOpenProjects()[0]).openFile(mockVirtualFile, true);
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
