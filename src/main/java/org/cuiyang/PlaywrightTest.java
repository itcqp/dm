package org.cuiyang;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.util.Iterator;

/**
 * @version 1.0.0
 * @Author chenqp
 * @Date 2024/4/9
 * @describe
 */
public class PlaywrightTest {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();

        String first = "D:\\downloads\\chromium-win64\\chrome-win";
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setExecutablePath(Paths.get(URI.create(first))));
//        Browser browser = playwright.chromium().launch();
        Page page = browser.newPage();

        page.navigate("https://www.baidu.com/");

        System.out.println(page.title());
    }
}
