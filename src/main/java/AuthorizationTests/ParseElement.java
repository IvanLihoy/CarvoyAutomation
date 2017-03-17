package AuthorizationTests;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan on 17.03.2017.
 */
public class ParseElement {
    public static void main(String[] args) throws IOException {
        List<FindError>findErrorsList = new ArrayList<>();
        Document doc = Jsoup.parse("http://leaseforlease.clever-solution.com/");
        Elements inputElement = doc.getElementsByAttributeValue("class", "inline-block");


    }
}
class FindError{
    private String url;
    private String name;

    public FindError(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setName(String name) {
        this.name = name;
    }
}
