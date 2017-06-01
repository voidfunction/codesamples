package my.sample.javafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

/**
 * Created by ltian on 5/31/2017.
 */
public class FxUtils {
    public static int counter = 0;

    public String getString() {
        return String.format("returned value:  %d", ++counter);
    }

//    public void openDefaultBrowser( final String url) {
//        Application application = new Application() {
//            @Override
//            public void start(Stage primaryStage) throws Exception {
//                getHostServices().showDocument(url);
//            }
//        };
//
//        try {
//            application.start(null);
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
