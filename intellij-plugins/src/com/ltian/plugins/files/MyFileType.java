package com.ltian.plugins.files;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.util.IconUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Created by ltian on 5/23/2017.
 */
public class MyFileType implements FileType {
    public static final MyFileType INSTANCE = new MyFileType();
    @NotNull
    @Override
    public String getName() {
        return "MySampleFileType";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "My Sample File Type Description";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "myExtension";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return IconUtil.getEditIcon();
    }

    @Override
    public boolean isBinary() {
        return false;
    }

    @Override
    public boolean isReadOnly() {
        return true;
    }

    @Nullable
    @Override
    public String getCharset(@NotNull VirtualFile file, @NotNull byte[] content) {
        return "utf-8";
    }
}
