package org.cuiyang;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.StrUtil;
import com.microsoft.playwright.*;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.util.Iterator;

/**
 * @version 1.0.0
 * @Author chenqp
 * @Date 2024/4/9
 * @describe
 */
public class PlaywrightTest {
    public static void main(String[] args) throws URISyntaxException {
        Playwright playwright = Playwright.create();
        String filePath = "D:\\downloads\\chromium-win64\\chrome-win\\chrome.exe";
        Path path = Paths.get(filePath);
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setExecutablePath(path).setHeadless(false));
//        Browser browser = playwright.chromium().launch();
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        page.navigate("https://www.baidu.com/");
        ThreadUtil.sleep(1000);
        APIRequestContext request = page.request();
        APIResponse apiResponse = request.get("https://www.baidu.com/?word=123");
        Keyboard keyboard = page.keyboard();
        keyboard.down("F12");
        keyboard.up("F12");


    }
}
