package my.sample.javafx;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
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
        final String userDir = System.getProperty("user.dir");
        final String htmlIndexFile = "file:///" + userDir + "/src/main/resources/html/index.html";
        final JSObject win = (JSObject) webEngine.executeScript("window");
        final FxUtils utils = new FxUtils();
        final String myurl = "file:///C:\\Users\\ltian\\project\\azure-tools-for-java/Utils/hdinsight-node-common/resources/htmlResources/hdinsight/job/html/index.html?clusterName=spark2withblob&port=29104&engineType=javafx";

        webEngine.getLoadWorker().stateProperty().addListener(
                new ChangeListener<Worker.State>() {
                    @Override
                    public void changed(ObservableValue<? extends Worker.State> ov,
                                        Worker.State oldState, Worker.State newState) {
                        if (newState == Worker.State.SUCCEEDED) {
                            if(win.getMember("key").toString().equalsIgnoreCase("undefined")) {
                                win.setMember("key", "value");
                            }

                            if(win.getMember("util").toString().equalsIgnoreCase("undefined")) {
                                win.setMember("util", utils);
                            }
                        }
                    }
                }
        );

        webEngine.load(myurl);
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
