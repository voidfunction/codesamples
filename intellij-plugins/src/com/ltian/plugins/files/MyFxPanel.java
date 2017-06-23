package com.ltian.plugins.files;

import com.teamdev.jxbrowser.chromium.*;
import com.teamdev.jxbrowser.chromium.javafx.BrowserView;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;

/**
 * Created by ltian on 5/24/2017.
 */
public class MyFxPanel extends JFXPanel {

    BrowserView webView;

    public MyFxPanel() {
        init(this);
    }

    private void init(final MyFxPanel fxPanel) {
        Platform.setImplicitExit(false);
        Platform.runLater(()-> {
            com.teamdev.jxbrowser.chromium.Browser browser = new com.teamdev.jxbrowser.chromium.Browser();
            webView = new BrowserView(browser);


            BorderPane borderPane = new BorderPane();
            borderPane.setCenter(webView);
            Scene scene = new Scene(borderPane, 7, 5);
            fxPanel.setScene(scene);
            browser.loadURL("https://www.google.com/");
//            webView = new WebView();
//            webEngine = webView.getEngine();
//            webEngine.setJavaScriptEnabled(true);
//            JSUtils utils = new JSUtils();
//            JSObject win = (JSObject) webEngine.executeScript("window");
//            win.setMember("Utils", (Object)utils);
//            win.setMember("testa","value");
//            fxPanel.setScene(new Scene(webView));
//
//            webEngine.load("file:///E:/html/index.html");
        });
    }
}
