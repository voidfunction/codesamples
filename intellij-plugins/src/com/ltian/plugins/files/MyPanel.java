package com.ltian.plugins.files;

import com.teamdev.jxbrowser.chromium.swing.BrowserView;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

/**
 * Created by ltian on 6/15/2017.
 */
public class MyPanel extends JPanel {
    public MyPanel() {
        com.teamdev.jxbrowser.chromium.Browser browser = new com.teamdev.jxbrowser.chromium.Browser();
        BrowserView view = new BrowserView(browser);
        JButton button = new JButton("Test");
        JButton button2 = new JButton("test2");
        this.setLayout(new BorderLayout());
//        this.add(button, BorderLayout.WEST);
        this.add(view, BorderLayout.CENTER);
//        this.add(button2, BorderLayout.EAST);
        //browser.loadURL("https://www.google.c
        //
        // om/");
        //browser.loadHTML("<html><body><h1>Hello World!</h1></body></html>");
        browser.loadURL("http://html5test.com");
        this.setSize(700, 500);
        this.setMinimumSize(new Dimension(700, 500));
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setContentPane(new MyPanel());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(2000, 1000);
        frame.setVisible(true);
    }
}
