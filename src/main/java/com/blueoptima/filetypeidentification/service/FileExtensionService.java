package com.blueoptima.filetypeidentification.service;

import com.blueoptima.filetypeidentification.domain.FileType;
import com.blueoptima.filetypeidentification.util.FileTypeUtil;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;


/**
 * The @{@link FileExtensionService} implements an application that
 * simply get file type information from Data sources for all file types or file names.
 *
 * @author Bhavesh Patel
 * @version 1.0
 * @since 2018-03-08
 */
public class FileExtensionService {

    /**
     * This method is used to get file type information like name, short description etc
     * for list of file names or file extensions.
     *
     * @param fileNames The list of file names or file extensions
     * @return List<FileType> This returns list of file type information for all file names and file extensions
     */
    public List<FileType> findFileTypeInfomations(String[] fileNames) {
        if (fileNames == null || fileNames.length <= 0)
            return null;
        ExecutorService executor = Executors.newFixedThreadPool(Math.min(fileNames.length, 100));
        List<CompletableFuture<FileType>> futures = Arrays.asList(fileNames).stream()
                .map(fileName -> CompletableFuture.supplyAsync(() -> new DataSourceService().getFileTypeFromDataSources(FileTypeUtil.getFileType(fileName)), executor))
                .collect(Collectors.toList());

        List<FileType> result = futures.stream().map(CompletableFuture::join).collect(Collectors.toList());
        if (!executor.isShutdown())
            executor.shutdown();
        return result;
    }
}
