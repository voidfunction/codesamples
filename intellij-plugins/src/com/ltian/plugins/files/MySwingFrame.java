package com.ltian.plugins.files;

/**
 * Created by ltian on 6/15/2017.
 */


    import com.teamdev.jxbrowser.chromium.Browser;
        import com.teamdev.jxbrowser.chromium.swing.BrowserView;

        import javax.swing.*;
        import java.awt.*;

/**
 * The sample demonstrates how to create Browser instance, embed it,
 * load HTML content from string, and display it.
 */
public class MySwingFrame {
    public static void main(String[] args) {
        Browser browser = new Browser();
        BrowserView view = new BrowserView(browser);

        JFrame frame = new JFrame("JxBrowser - Hello World");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(view, BorderLayout.CENTER);
        frame.setSize(5000, 4000);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        browser.loadURL("https://www.google.com/");
    }
}