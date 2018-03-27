package com.blueoptima.filetypeidentification.parser;

import com.blueoptima.filetypeidentification.domain.DataSource;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DataSourceFactoryTest {

    private DataSource dataSource1, dataSource2;

    @Before
    public void setUp() throws Exception {
        dataSource1 = new DataSource("filext", "http://filext.com/file-extension/{file_type}");
        dataSource2 = new DataSource("abc", "http://abc.info/{file_type}");
    }

    @After
    public void tearDown() throws Exception {
        dataSource1 = null;
        dataSource2 = null;
    }

    @Test
    public void getDataSourceParser() {
        Assert.assertNotNull(DataSourceFactory.getDataSourceParser(dataSource1));
        Assert.assertNull(DataSourceFactory.getDataSourceParser(dataSource2));
        Assert.assertNull(DataSourceFactory.getDataSourceParser(null));
    }
}