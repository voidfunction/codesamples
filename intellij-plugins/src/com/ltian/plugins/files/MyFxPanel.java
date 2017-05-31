package com.ltian.plugins.files;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;

/**
 * Created by ltian on 5/24/2017.
 */
public class MyFxPanel extends JFXPanel {

    WebView webView;
    private WebEngine webEngine;

    public MyFxPanel() {
        init(this);
    }

    private void init(final MyFxPanel fxPanel) {
        Platform.setImplicitExit(false);
        Platform.runLater(()-> {
            webView = new WebView();
            webEngine = webView.getEngine();
            webEngine.setJavaScriptEnabled(true);
            JSUtils utils = new JSUtils();
            JSObject win = (JSObject) webEngine.executeScript("window");
            win.setMember("Utils", (Object)utils);
            win.setMember("testa","value");
            fxPanel.setScene(new Scene(webView));

            webEngine.load("file:///E:/html/index.html");
        });
    }
}
