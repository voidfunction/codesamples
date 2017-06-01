package my.sample.javafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by ltian on 5/31/2017.
 */
public class FxUtils {
    public static int counter = 0;

    public String getString() {
        return String.format("returned value:  %d", ++counter);
    }

    public void openDefaultBrowser( final String url) {

        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(new URI(url));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
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
    }
}
