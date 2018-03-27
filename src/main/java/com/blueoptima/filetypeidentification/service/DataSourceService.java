package com.blueoptima.filetypeidentification.service;

import com.blueoptima.filetypeidentification.domain.DataSource;
import com.blueoptima.filetypeidentification.domain.FileType;
import com.blueoptima.filetypeidentification.exception.DataSourceNotFoundException;
import com.blueoptima.filetypeidentification.exception.ParserNotFound;
import com.blueoptima.filetypeidentification.parser.DataSourceFactory;
import com.blueoptima.filetypeidentification.parser.IDataSourceParser;
import com.blueoptima.filetypeidentification.util.DataSourceUtil;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * The @{@link DataSourceService} implements an application that
 * simply get file type information from Data sources which are defined in
 * Properties file.
 *
 * @author Bhavesh Patel
 * @version 1.0
 * @since 2018-03-08
 */
public class DataSourceService {

    /**
     * This method is used to get file type information like name, short description etc
     * from the data sources.
     *
     * @param fileType The file type which you want to get information from data sources.
     * @return FileType This returns All information related file type.
     */
    public FileType getFileTypeFromDataSources(String fileType) {
        List<DataSource> dataSources = DataSourceUtil.getDataSources();
        if (dataSources == null || dataSources.size() <= 0)
            throw new DataSourceNotFoundException("Datasource not found in properties file. Please add data source in properties file");
        FileType.FileTypeBuilder fileTypeBuilder = new FileType.FileTypeBuilder().setFileType(fileType);
        ExecutorService executor = Executors.newFixedThreadPool(Math.min(dataSources.size(), 10));
        List<CompletableFuture<FileType.FileTypeBuilder>> futures = dataSources.stream()
                .map(dataSource -> CompletableFuture.supplyAsync(() -> {
                    IDataSourceParser dataSourceParser = DataSourceFactory.getDataSourceParser(dataSource);
                    if (dataSourceParser == null)
                        throw new ParserNotFound("Parser not found for data source: " + dataSource.getName() + ". Please implement the parser for this data source.");
                    dataSourceParser.fetchDataFromDataSource(fileType, fileTypeBuilder);

                    return fileTypeBuilder;
                }, executor))
                .collect(Collectors.toList());
        futures.stream().map(CompletableFuture::join).collect(Collectors.toList());


        // from three data source

        //short descri - filesuffix
        if (!executor.isShutdown())
            executor.shutdown();
        FileType fileInfo = fileTypeBuilder.build();
        System.out.println(fileInfo);
        return fileInfo;
    }

    public FileType getFileTypeFromDataSourcesOld(String fileType) {
        List<DataSource> dataSources = DataSourceUtil.getDataSources();
        if (dataSources == null || dataSources.size() <= 0)
            throw new DataSourceNotFoundException("Datasource not found in properties file. Please add data source in properties file");
        FileType.FileTypeBuilder fileTypeBuilder = new FileType.FileTypeBuilder().setFileType(fileType);
        dataSources.forEach(dataSource -> {
            IDataSourceParser dataSourceParser = DataSourceFactory.getDataSourceParser(dataSource);
            if (dataSourceParser == null)
                throw new ParserNotFound("Parser not found for data source: " + dataSource.getName() + ". Please implement the parser for this data source.");
            dataSourceParser.fetchDataFromDataSource(fileType, fileTypeBuilder);
        });FileType fileInfo = fileTypeBuilder.build();
        return fileInfo;
    }

}
