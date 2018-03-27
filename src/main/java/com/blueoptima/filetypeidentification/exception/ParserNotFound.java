package com.blueoptima.filetypeidentification.exception;

/**
 * This exception may be thrown by a {@link com.blueoptima.filetypeidentification.service.DataSourceService}
 * if it is unable to find parser for specific data source.
 *
 * @author Bhavesh Patel
 * @version 1.0
 * @since 2018-03-08
 */
public class ParserNotFound extends RuntimeException {

    public ParserNotFound(String message) {
        super(message);
    }
}
