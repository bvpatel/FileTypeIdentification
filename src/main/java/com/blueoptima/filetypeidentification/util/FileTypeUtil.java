package com.blueoptima.filetypeidentification.util;


/**
 * The {@link FileTypeUtil} represents utilities for file extension.
 *
 * @author Bhavesh Patel
 * @version 1.0
 * @since 2018-03-08
 */
public final class FileTypeUtil {

    /**
     * This method is used to get file extension from the file name.
     * If unable to find file extension then it simply returns file name.
     *
     * @param fileName to be used to get file extension.
     * @return String The file extension of file name.
     */
    public static String getFileType(String fileName) {
        if (fileName.lastIndexOf(".") != -1)
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        else return fileName;
    }
}
