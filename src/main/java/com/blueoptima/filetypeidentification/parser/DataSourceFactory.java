package com.blueoptima.filetypeidentification.parser;

import com.blueoptima.filetypeidentification.domain.DataSource;

/**
 * The {@link DataSourceFactory} use to get Data source parser based on the data source.
 *
 * @author Bhavesh Patel
 * @version 1.0
 * @since 2018-03-08
 */
public final class DataSourceFactory {

    /**
     * This method is used to get data source parser based on the data source.
     *
     * @param dataSource The data source to be used to get parser
     * @return IDataSourceParser The parser of the data source
     */
    public static IDataSourceParser getDataSourceParser(DataSource dataSource) {
        if (dataSource != null) {
            if (dataSource.getName().equalsIgnoreCase("filext")) {
                return new FilextParser(dataSource);
            } else if (dataSource.getName().equalsIgnoreCase("filesuffix")) {
                return new FileSuffixParser(dataSource);
            } else if (dataSource.getName().equalsIgnoreCase("fileinfo")) {
                return new FileInfoParser(dataSource);
            }
        }
        return null;
    }
}
