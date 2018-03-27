package com.blueoptima.filetypeidentification.parser;

import com.blueoptima.filetypeidentification.domain.DataSource;
import com.blueoptima.filetypeidentification.domain.FileType;
import com.blueoptima.filetypeidentification.util.HTMLUtil;
import com.blueoptima.filetypeidentification.util.URLUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.List;

/**
 * The {@link FilextParser} represents parser of filext data source.
 *
 * @author Bhavesh Patel
 * @version 1.0
 * @since 2018-03-08
 */
public class FilextParser implements IDataSourceParser {

    private DataSource dataSource;

    public FilextParser(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * This method is used to get file type information from filext data source.
     *
     * @param fileType        The fileType to be used to get file type information from filext data source.
     * @param fileTypeBuilder The fileTypeBuilder to be used to store file type information.
     */
    public void fetchDataFromDataSource(String fileType, FileType.FileTypeBuilder fileTypeBuilder) {
        Document document = HTMLUtil.getDocumentByURL(URLUtil.getURL(dataSource.getUrl(), fileType));
        if (document == null)
            return;
        Element infoElement = document.body().getElementById("extended-info");
        if (infoElement != null) {
            for (Element element : infoElement.children()) {
                if (element.getElementsByTag("strong").text().toLowerCase().startsWith("primary association")) {
                    fileTypeBuilder.setLanguageFamily(element.text().replaceAll("Primary association:", "").trim());
                } else if (element.getElementsByTag("strong").text().toLowerCase().startsWith("mime type")) {
                    fileTypeBuilder.addMimeType(element.text().replaceAll("Mime type:", "").trim().split(","));
                } else if (element.getElementsByTag("strong").text().toLowerCase().startsWith("company")) {
                    fileTypeBuilder.setCompany(element.text().replaceAll("Company:", "").trim());
                } else if (element.getElementsByTag("strong").text().toLowerCase().startsWith("file classification")) {
                    fileTypeBuilder.setCompany(element.text().replaceAll("File classification:", "").trim());
                } else if (element.getElementsByTag("strong").text().toLowerCase().startsWith("program")) {
                    fileTypeBuilder.addApplications(element.text().replaceAll("Program ID:", "").trim().split(","));
                } else if (element.getElementsByTag("strong").text().toLowerCase().startsWith("related links")) {
                    fileTypeBuilder.addApplications(element.text().replaceAll("Related links:", "").trim().split(","));
                }
            }
        }
    }
}
