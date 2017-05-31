package com.ltian.plugins.files;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;

import java.net.URI;

/**
 * Created by ltian on 5/24/2017.
 */
public class MyTestApplication extends Application {
    static WebView webView;
    private static WebEngine webEngine;


//    public static void main(String[] args) {
//
//        final Application application = new Application() {
//            @Override
//            public void start(Stage primaryStage) throws Exception {
//
//            }
//        };
//
//        Platform.setImplicitExit(false);
//        Platform.runLater(()-> {
//            try {
//                application.start(null);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
//    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        webView = new WebView();
        webEngine = webView.getEngine();
        webEngine.setJavaScriptEnabled(true);
        JSUtils utils = new JSUtils();
        JSObject win = (JSObject) webEngine.executeScript("window");
        win.setMember("my", utils);
        win.setMember("testa", "abc");
        URI uri = URI.create("file:///E:/htmltest/index.html") ;
        webEngine.getLoadWorker().stateProperty().addListener(
                (ObservableValue<? extends Worker.State> ov, Worker.State oldState,
                 Worker.State newState) -> {
                    if (newState == Worker.State.SUCCEEDED) {
                        win.setMember("app", new JSUtils());
                    }
                });
        webEngine.load(uri.toString());
        primaryStage.setScene(new Scene(webView));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
//        new JSUtils().openDefaultBrowser("https://www.google.com/");
    }
}
