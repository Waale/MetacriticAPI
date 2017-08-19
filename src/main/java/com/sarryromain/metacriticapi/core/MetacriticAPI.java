package com.sarryromain.metacriticapi.core;

import com.sarryromain.metacriticapi.core.interfaces.IMetacriticAPI;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Created by Romain on 29/07/2017.
 */
public class MetacriticAPI implements IMetacriticAPI {
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
        return name.replace(" ", "-").replace("'", "").replace(":", "").replace("--", "-").toLowerCase();
    }
}
