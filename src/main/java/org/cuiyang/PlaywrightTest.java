package org.cuiyang;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.StrUtil;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;

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
        page.waitForLoadState(LoadState.NETWORKIDLE);
//        page.pause(); //开启了，就会启动Playwright Inspector调试工具
//        page.type("#kw", "666");
        page.locator("#kw").click();
        page.locator("#kw").fill("666");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("百度一下")).click();

    }
}
