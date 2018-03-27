package com.blueoptima.filetypeidentification.parser;

import com.blueoptima.filetypeidentification.domain.FileType;


/**
 * The {@link IDataSourceParser} interface for parser of data source.
 *
 * @author Bhavesh Patel
 * @version 1.0
 * @since 2018-03-08
 */
public interface IDataSourceParser {
    void fetchDataFromDataSource(String fileType, FileType.FileTypeBuilder fileTypeBuilder);
}
