import org.jsoup.Jsoup;
import org.seimicrawler.xpath.JXDocument;
import org.seimicrawler.xpath.JXNode;

import java.io.File;
import java.util.List;

public class ParseWifi {
    public static void main(String[] args) throws Exception {
        //获取资源路径
        String path = ParseWifi.class.getResource("WifiConfigStore.xml").getPath();
        //创建支持XPath的document数据结构
        JXDocument document = JXDocument.create(Jsoup.parse(new File(path), "UTF-8"));

        List<JXNode> ssid = document.selN("//WifiConfiguration/*[@name=\"SSID\"]/text()");
        List<JXNode> pass = document.selN("//WifiConfiguration/*[@name=\"PreSharedKey\"]/text()");
        for (int i = 0; i < ssid.size(); i++) {
            System.out.println(ssid.get(i).asString() + ":" + pass.get(i).asString());
        }
    }
}
