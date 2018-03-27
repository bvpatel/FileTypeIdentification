package com.blueoptima.filetypeidentification.exception;

/**
 * This exception may be thrown by a {@link com.blueoptima.filetypeidentification.service.DataSourceService}
 * if it is unable to find data source from properties file.
 *
 * @author Bhavesh Patel
 * @version 1.0
 * @since 2018-03-08
 */
public class DataSourceNotFoundException extends RuntimeException {

    public DataSourceNotFoundException(String message) {
        super(message);
    }

}
