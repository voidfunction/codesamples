package my.sample.html;

import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;

import java.util.Arrays;

/**
 * Created by ltian on 5/24/2017.
 */
public class MyHtmlUtils {
    public static void main(String[] args) throws Exception {
        CredentialsProvider provider = new BasicCredentialsProvider();
        provider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials("admin", "Pa$$w0rd1234"));
        final WebClient client = new WebClient();
        client.setCredentialsProvider(provider);
        String url = "https://spark2withblob.azurehdinsight.net/yarnui/jobhistory/logs/10.0.0.4/port/30050/container_e06_1495159635595_0019_05_000001/container_e06_1495159635595_0019_05_000001/livy";

        String log1 = "https://spark2withblob.azurehdinsight.net/yarnui/jobhistory/logs/10.0.0.4/port/30050/container_e06_1495159635595_0019_05_000001/container_e06_1495159635595_0019_05_000001/livy/directory.info/?start=0";

        HtmlPage page = client.getPage(log1);
        final String xpath = "//html[1]/body[1]/table[1]/tbody[1]/tr[1]/td[1]/pre[1]";
        String content = page.getElementsByTagName("pre").get(0).getTextContent();
        String[] lines = content.split("\n");
        Arrays.stream(lines).forEach(System.out::println);
        //String content2 = page.getFirstByXPath(xpath);
        System.out.println(page.asXml());
    }
}
