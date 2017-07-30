package com.sarryromain.metacriticapi.core;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Romain on 29/07/2017.
 */
public class MetacriticPage {
    public MetacriticPage(Document htmlDom) {
        this.htmlDom = htmlDom;
    }

    Document htmlDom;

    SimpleDateFormat formatter = new SimpleDateFormat("MMMMM d, yyyy", Locale.US);

    public Document getHtmlDom() {
        return htmlDom;
    }

    public void setHtmlDom(Document htmlDom) {
        this.htmlDom = htmlDom;
    }

    public String getFieldAsText(String selector) {
        return getHtmlDom().select(selector).first().text();
    }

    public List<String> getFieldsAsText(String selector) {
        return getHtmlDom().select(selector).eachText();
    }

    public Date getFieldAsDate(String selector) {
        try {
            return formatter.parse(getFieldAsText(selector));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Element getField(String selector) {
        return getHtmlDom().select(selector).first();
    }
}
