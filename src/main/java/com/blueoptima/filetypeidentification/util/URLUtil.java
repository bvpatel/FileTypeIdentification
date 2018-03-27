package com.blueoptima.filetypeidentification.util;

/**
 * The {@link URLUtil} represents the utilities related URL
 *
 * @author Bhavesh Patel
 * @version 1.0
 * @since 2018-03-08
 */
public final class URLUtil {

    /**
     * This method is used to replace file type token in URL template
     *
     * @param url      The url template
     * @param fileName Actual value of file type token
     * @return String The final URL
     */
    public static String getURL(String url, String fileName) {
        return url.replaceAll("\\{file_type\\}", fileName);
    }
}
