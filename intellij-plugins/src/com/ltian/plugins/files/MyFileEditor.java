package com.ltian.plugins.files;

import com.intellij.codeHighlighting.BackgroundEditorHighlighter;
import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.fileEditor.FileEditorLocation;
import com.intellij.openapi.fileEditor.FileEditorState;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Key;
import com.intellij.openapi.vfs.VirtualFile;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.teamdev.jxbrowser.chromium.Browser;
import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeListener;

/**
 * Created by ltian on 5/24/2017.
 */
public class MyFileEditor implements FileEditor {

    private final Project myProject;
    private final VirtualFile myVirtualFile;
    private final JComponent myComponent;

    public MyFileEditor(@NotNull Project project, @NotNull VirtualFile virtualFile) {
        this.myProject = project;
        this.myVirtualFile = virtualFile;
        this.myComponent = new MyPanel();
        int a = 1;
    }

//    private static JComponent getMyComponent() {
//        return new MyPanel();
////        Browser browser = new Browser();
////        BrowserView browserView = new BrowserView();
////        JComponent frame = new JPanel();
////        frame.add(browserView, BorderLayout.CENTER);
////        frame.setSize(700, 500);
////        frame.setVisible(true);
////
////        browser.loadURL("http://www.google.com");
////        return frame;
//    }

    @NotNull
    @Override
    public JComponent getComponent() {
        return myComponent;
    }

    @Nullable
    @Override
    public JComponent getPreferredFocusedComponent() {
//        return getMyComponent();
        return myComponent;
    }

    @NotNull
    @Override
    public String getName() {
        return myVirtualFile.getName();
    }

    @Override
    public void setState(@NotNull FileEditorState state) {

    }

    @Override
    public boolean isModified() {
        return false;
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public void selectNotify() {

    }

    @Override
    public void deselectNotify() {

    }

    @Override
    public void addPropertyChangeListener(@NotNull PropertyChangeListener listener) {

    }

    @Override
    public void removePropertyChangeListener(@NotNull PropertyChangeListener listener) {

    }

    @Nullable
    @Override
    public BackgroundEditorHighlighter getBackgroundHighlighter() {
        return null;
    }

    @Nullable
    @Override
    public FileEditorLocation getCurrentLocation() {
        return null;
    }

    @Override
    public void dispose() {

    }

    @Nullable
    @Override
    public <T> T getUserData(@NotNull Key<T> key) {
        return null;
    }

    @Override
    public <T> void putUserData(@NotNull Key<T> key, @Nullable T value) {

    }
}
