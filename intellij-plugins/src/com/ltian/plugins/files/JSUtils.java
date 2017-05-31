package com.ltian.plugins.files;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

/**
 * Created by ltian on 5/24/2017.
 */
public class JSUtils {

    public String getKey() {
        return "key";
    }

    public void openDefaultBrowser(@NotNull final String url) {
        Application application = new Application() {
            @Override
            public void start(Stage primaryStage) throws Exception {
                getHostServices().showDocument(url);
            }
        };
        try {
            application.start(null);

        } catch (Exception e) {

        }
    }
}
