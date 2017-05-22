package my.sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;

/**
 * Created by ltian on 5/18/2017.
 */
public class FxWebView extends Application {
    @Override
    public void init() throws Exception {
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        final WebView view = new WebView();
        final WebEngine webEngine = view.getEngine();
        webEngine.setJavaScriptEnabled(true);
        JSObject win = (JSObject) webEngine.executeScript("window");
        final String userDir = System.getProperty("user.dir");
        final String htmlIndexFile = "file:///" + userDir + "/src/main/resources/html/index.html";

        win.setMember("key", "value");
        webEngine.load(htmlIndexFile);
        primaryStage.setScene(new Scene(view, 600, 600));
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
