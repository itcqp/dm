package org.cuiyang.dm.test;

import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import org.cuiyang.dm.DmSoft;

import java.util.ArrayList;
import java.util.List;

/**
 * test
 *
 * @author cuiyang
 */
public class DmSoftTest {
    public static List<String> tmeplist = new ArrayList<>();
    public static void main(String[] args) throws InterruptedException {
        DmSoft dm = new DmSoft();
//        int hwnd = dm.findWindow("", "player");
        int hwnd = 199302;
        int i = dm.bindWindow(hwnd, "normal", "normal", "windows", 0);
//        dm.setDict(0, "D:\\devin\\project\\dm\\src\\main\\resources\\devindict.txt");
//        int i = dm.bindWindow(hwnd, "gdi2", "windows", "windows", 0);
//        int i = dm.bindWindowEx(hwnd, "normal", "dx.mouse.api", "windows","dx.public.disable.window.size", 0);
        dm.setWindowState(hwnd, 1);
        Thread.sleep(1000);
//        String picEx = dm.findPicEx(0, 0, 1920, 1080, "D:\\devin\\project\\dm\\src\\main\\resources\\dtest12.bmp", "000000", 0.9, 1);
//        System.out.println(picEx);
//        if (picEx != null && picEx.length() >0) {
//            String[] split = picEx.split(",");
//            dm.moveTo(Integer.valueOf(split[1]), Integer.valueOf(split[2]));
//        }
//        String ocr = dm.ocr(0, 0, 1980, 1080, "9f9a8b-61625d|61625d-000000|858378-000000|6d6e66-000000|868378-000000|817f74-000000|8e8b7e-000000", 0.1);
//        String x = "0";
//        String y = "0";
//        Variant intX = new Variant(0,true);
//        Variant intY= new Variant(0,true);
//
////        String ocr = dm.findStrE(0, 0, 1980, 1080, "综合", "ffffff-000000", 0.1);
//        String ocr = dm.findStrE(0, 0, 1980, 1080, "战利品", "837c6b-444444", 0.6);
//        System.out.println(ocr);
//        if (ocr != null && ocr.length() >0) {
//            String[] split = ocr.split("\\|");
//            dm.moveTo(Integer.valueOf(split[1]), Integer.valueOf(split[2]));
//        }
//        dm.moveTo(Integer.valueOf(intX.getVariant().toString()), Integer.valueOf(intY.getVariant().toString()));
        String    picEx = dm.findPicE(0,0,1058,740, "D:\\devin\\project\\dm\\src\\main\\resources\\dtest4.bmp", "000000", 0.8, 1);
        System.out.println(picEx);
        modveAndLeftClick(dm, picEx,5, 5);
        Thread.sleep(300);
        int k = 0;
        while (k <100) {
            k++;
            String ocr = dm.findColorE(640,308,1055,694, "ffffff-000000", 0.8, 1);
            if (ocr != null && ocr.length() >0) {
                System.out.println(ocr);
                String[] split = ocr.split("\\|");
                dm.moveTo(Integer.valueOf(split[0])+1, Integer.valueOf(split[1])+1);
                dm.leftClick();
//                Thread.sleep(50);
            }
        }

//            Thread.sleep(200);
//            long begin = System.currentTimeMillis();
//            picEx = dm.findPicEx(378,241,830,664, "D:\\devin\\project\\dm\\src\\main\\resources\\dtest21.bmp", "666666-000000|ffffff-000000", 1.0, 1);
//            long end = System.currentTimeMillis();
//            long ll = begin - end;
//            System.out.println("耗时：" + ll);
//            int px = 35;
//            if (ll >35) {
//                ll = 0;
//            }else{
//                px = (int) (35 - ll);
//            }
//            modveAndLeftClick(dm, picEx, (int) (ll +20),1);
//        System.out.println("version:" + dm.ver());
//        System.out.println("path:" + dm.getBasePath());
    }

    private static void modveAndLeftClick(DmSoft dm, String picEx, int wyy, int wyx) throws InterruptedException {
        if (picEx != null && !"".equals(picEx)) {
        System.out.println(picEx);
            String[] s1 = picEx.split("\\|");
            for (int i = 0; i < s1.length; i++) {
                String[] split = s1[i].split(",");
                int x = Integer.valueOf(s1[1])+wyx;
                int y = Integer.valueOf(s1[2])+wyy;
                if (tmeplist.contains(x+","+y)) {
                    continue;
                }else{
                    tmeplist.add(x + "," + y);
                }
                dm.moveTo(x, y);
                dm.leftClick();
                System.out.println("第"+i+"次点击");
                break;
            }
        }

    }
}
