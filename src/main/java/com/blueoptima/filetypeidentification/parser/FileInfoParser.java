package com.blueoptima.filetypeidentification.parser;

import com.blueoptima.filetypeidentification.domain.DataSource;
import com.blueoptima.filetypeidentification.domain.FileType;
import com.blueoptima.filetypeidentification.util.HTMLUtil;
import com.blueoptima.filetypeidentification.util.URLUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.List;


/**
 * The {@link FileInfoParser} represents parser of file info data source.
 *
 * @author Bhavesh Patel
 * @version 1.0
 * @since 2018-03-08
 */
public class FileInfoParser implements IDataSourceParser {

    private DataSource dataSource;

    public FileInfoParser(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * This method is used to get file type information from fileinfo data source.
     *
     * @param fileType        The fileType to be used to get file type information from fileinfo data source.
     * @param fileTypeBuilder The fileTypeBuilder to be used to store file type information.
     */
    public void fetchDataFromDataSource(String fileType, FileType.FileTypeBuilder fileTypeBuilder) {
        Document document = HTMLUtil.getDocumentByURL(URLUtil.getURL(dataSource.getUrl(), fileType));
        if (document == null)
            return;
        List<Element> headerInfoElements = document.body().getElementsByClass("headerInfo");
        if (headerInfoElements != null && !headerInfoElements.isEmpty()) {
            Element headerInfo = headerInfoElements.get(0);
            if (headerInfo != null && headerInfo.child(0) != null) {
                Element table = headerInfo.child(0);
                for (Element tr : table.children()) {
                    Element td = tr.child(0);
                    if (td != null && td.hasText()) {
                        if (td.text().equalsIgnoreCase("Developer")) {
                            fileTypeBuilder.setCompany(td.nextElementSibling().text());
                        } else if (td.text().equalsIgnoreCase("Category")) {
                            fileTypeBuilder.setCategory(td.nextElementSibling().text());
                        } else if (td.text().equalsIgnoreCase("Format")) {
                            fileTypeBuilder.setFormat(td.nextElementSibling().child(0).text());
                        }
                    }
                }
            }
        }
        List<Element> names = document.body().select("[itemprop=name]");
        if (names != null && !names.isEmpty()) {
            Element name = names.get(0);
            if (name != null && name.hasText())
                fileTypeBuilder.setFileTypeName(name.text());
        }
        List<Element> descriptions = document.body().select("[itemprop=description]");
        if (descriptions != null && !descriptions.isEmpty()) {
            Element description = descriptions.get(0);
            if (description != null && description.hasText())
                fileTypeBuilder.setShortDescription(description.text());
        }

    }
}
