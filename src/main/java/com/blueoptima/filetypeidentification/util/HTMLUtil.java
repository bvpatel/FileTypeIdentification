package com.blueoptima.filetypeidentification.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * The {@link HTMLUtil} represents utilities for HTML related activities.
 *
 * @author Bhavesh Patel
 * @version 1.0
 * @since 2018-03-08
 */
public final class HTMLUtil {

    /**
     * This method is used to get HTML in DOM format from URL.
     *
     * @param url used to get HTML in document format
     * @return Document The document which represents HTML in DOM format
     */
    public static Document getDocumentByURL(String url) {
        try {
            return Jsoup.connect(url).timeout(ConstantUtil.CONNECTION_TIMEOUT).get();
        } catch (IOException e) {
            //System.out.println("Unable to connect data source. URL: " + url + " .Please check url and update in datasource properties file.");
            return null;
        }
    }
}
