package metacriticapi.core;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Created by Romain on 29/07/2017.
 */
public class MetacriticAPI {
    public static final String URL_BASE = "http://www.metacritic.com/";

    public static final String URL_SEARCH = URL_BASE + "search/";

    public static final String URL_SEARCH_END = "/results";

    public MetacriticPage getPageByUrl(String url) {
        Document htmlDom = null;

        try {
            System.out.println("Fetching URL : " + url);
            htmlDom = Jsoup.connect(url).get();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return new MetacriticPage(htmlDom);
    }

    public String parseNameForUrl(String name) {
        return name.replace(" ", "-").replace("'", "").replace(":-", "").replace("&-", "").toLowerCase();
    }

    public String parseNameAndSeasonForUrl(String nameAndSeason) {
        String[] parts = nameAndSeason.split(": Season ");
        return parseNameForUrl(parts[0]) + "/season-" + parts[1];
    }
}
