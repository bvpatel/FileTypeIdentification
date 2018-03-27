package com.blueoptima.filetypeidentification.domain;

/**
 * The @{@link DataSource} use to store information about Data source.
 *
 * @author Bhavesh Patel
 * @version 1.0
 * @since 2018-03-08
 */
public class DataSource {
    private String name;
    private String url;

    public DataSource(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "DataSource{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
