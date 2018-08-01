package jc;

import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service("internalHttpClient")
public class InternalHttpClient {
    protected static final String EXPIRES_PATTERN = "EEE, dd-MMM-yy HH:mm:ss z";
    protected static final String VK_EXPIRES_PATTERN = "EEE, dd MMM yyyy HH:mm:ss z";
    public static final String SITE_URL = "http://34travel.by";
    public static final String URI = SITE_URL + "/post/festivals";
    private final CloseableHttpClient httpClient;
    private final List<Header> globalHeaders;
    private String charset = "UTF-8";

    public InternalHttpClient() {
        globalHeaders = new ArrayList<>(11);
        globalHeaders.add(new BasicHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8"));
        globalHeaders.add(new BasicHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.71 Safari/537.36"));
        globalHeaders.add(new BasicHeader("Upgrade-Insecure-Requests", "1"));
        globalHeaders.add(new BasicHeader("Accept-Encoding", "gzip, deflate, sdch"));
        globalHeaders.add(new BasicHeader("Accept-Language", "en-US,en;q=0.8,be;q=0.6,ru;q=0.4,uk;q=0.2"));
        globalHeaders.add(new BasicHeader("Cache-Control", "max-age=0"));
        globalHeaders.add(new BasicHeader("Connection", "keep-alive"));

        httpClient = HttpClients.custom().setDefaultCookieStore(new BasicCookieStore()).build();
    }

    public List<NameValuePair> parsePage() throws IOException {
        Document document = Jsoup.parse(new File("aaa.htm"), charset);
        Elements lineUpElements = document.getElementsContainingOwnText("LINE UP:");
        Map<String, Integer> groupsCount = new HashMap<>();
        for (Element element : lineUpElements) {
            Element parent = element.parent();
            Elements span = parent.getElementsByTag("span");
            List<String> collect = span.stream().map(Element::text).collect(Collectors.toList());
            for (String list: collect) {
                String[] groups = list.trim().split(",");
                groups = StringUtils.trimArrayElements(groups);
                for (String group: groups) {
                    String t = group.replaceAll(String.valueOf((char) 160), "").trim();
                    Integer count = groupsCount.get(t);
                    if (count == null) {
                        count = 0;
                    }
                    groupsCount.put(t, ++count);
                }
            }
        }
        ArrayList<Map.Entry<String, Integer>> entries = new ArrayList<>(groupsCount.entrySet());
        entries.sort((o1, o2) -> o2.getValue() - o1.getValue());
        File file = new File("out.txt");
        FileWriter writer = new FileWriter(file);
        entries.forEach(entry -> {
            try {
                String str = entry.getKey() + " => " + entry.getValue() + '\n';
                writer.write(str);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        writer.close();
        return Collections.emptyList();
    }


    private String parseCharset(String contentTypeHeader) {
        int i = contentTypeHeader.indexOf("charset=");
        if (i > -1) {
            charset = contentTypeHeader.substring(i + 8);
        }
        return charset;
    }

}
