package com.blueoptima.filetypeidentification.util;

import com.blueoptima.filetypeidentification.domain.FileType;
import sun.misc.ClassLoaderUtil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * The {@link FileUtil} represents utilities for file related activities.
 *
 * @author Bhavesh Patel
 * @version 1.0
 * @since 2018-03-08
 */
public final class FileUtil {

    /**
     * This method is used to read file by file name and returns the array of lines.
     *
     * @param fileName Read the file
     * @return String[] The lines of file in array of string
     */
    public static String[] readFileByFileName(String fileName) {
        List<String> lines = new ArrayList<>();
        try {
            ClassLoader classloader = new FileUtil().getClass().getClassLoader();
            URL url = classloader.getResource(fileName);
            Stream<String> streamLines = Files.lines(Paths.get(url.toURI()));
            streamLines.forEach(line -> lines.add(line));
            streamLines.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
            ex.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return lines.stream().toArray(String[]::new);
    }


    /**
     * This method is used to read file by file name and returns the array of lines.
     *
     * @param fileName Read the file
     * @param objects
     * @return String[] The lines of file in array of string
     */
    public static void writeFile(String fileName , List<FileType> objects) {
        StringBuffer buffer = new StringBuffer();
        objects.forEach(o -> buffer.append(o.toString()).append(System.getProperty("line.separator")));
        try {
            Files.write(Paths.get(fileName), buffer.toString().getBytes());
        } catch (IOException e) {
            System.out.println("Error writing file '" + fileName + "'");
            e.printStackTrace();
        }
    }

}
