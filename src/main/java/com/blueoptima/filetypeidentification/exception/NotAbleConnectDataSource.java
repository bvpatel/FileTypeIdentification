package com.blueoptima.filetypeidentification.exception;

/**
 * This exception may be thrown by Data source Parser if it is unable to connect data source.
 *
 * @author Bhavesh Patel
 * @version 1.0
 * @since 2018-03-08
 */
public class NotAbleConnectDataSource extends RuntimeException {
    public NotAbleConnectDataSource(String message) {
        super(message);
    }
}
