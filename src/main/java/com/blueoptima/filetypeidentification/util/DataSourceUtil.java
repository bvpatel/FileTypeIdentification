package com.blueoptima.filetypeidentification.util;

import com.blueoptima.filetypeidentification.domain.DataSource;
import com.blueoptima.filetypeidentification.exception.DataSourceNotFoundException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@link DataSourceUtil} represents utilities for Data source.
 *
 * @author Bhavesh Patel
 * @version 1.0
 * @since 2018-03-08
 */
public final class DataSourceUtil {

    /**
     * This method is used to get the list of data sources from properties file.
     *
     * @return List<DataSource> The list of data sources
     */
    public static List<DataSource> getDataSources() {
        List<DataSource> dataSources = new ArrayList<DataSource>();
        try {
            PropertyReader propertyReader = new PropertyReader(ConstantUtil.DATASOURCE_PROP_FILENAME);
            String dataSourceKey = propertyReader.getValue("datasource");
            if (dataSourceKey != null && !dataSourceKey.isEmpty()) {
                String[] sources = dataSourceKey.trim().split(",");
                for (String datasource : sources) {
                    if (!datasource.trim().isEmpty()) {
                        String url = propertyReader.getValue(datasource + ".url");
                        if (url != null && !url.isEmpty())
                            dataSources.add(new DataSource(datasource, url));
                    }
                }
            }
        } catch (IOException e) {
            throw new DataSourceNotFoundException("Datasource Properties file not found. Please add datasource Properties file.");
        }

        if (dataSources.size() <= 0)
            throw new DataSourceNotFoundException("Datasource not found in Properties file. Please add datasource in Properties file");
        return dataSources;
    }
}
