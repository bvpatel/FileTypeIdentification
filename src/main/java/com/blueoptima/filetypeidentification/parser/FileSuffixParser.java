package com.blueoptima.filetypeidentification.parser;

import com.blueoptima.filetypeidentification.domain.DataSource;
import com.blueoptima.filetypeidentification.domain.FileType;
import com.blueoptima.filetypeidentification.util.HTMLUtil;
import com.blueoptima.filetypeidentification.util.URLUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


/**
 * The {@link FileSuffixParser} represents parser of file suffix data source.
 *
 * @author Bhavesh Patel
 * @version 1.0
 * @since 2018-03-08
 */
public class FileSuffixParser implements IDataSourceParser {

    private DataSource dataSource;

    public FileSuffixParser(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * This method is used to get file type information from filesuffix data source.
     *
     * @param fileType        The fileType to be used to get file type information from filesuffix data source.
     * @param fileTypeBuilder The fileTypeBuilder to be used to store file type information.
     */
    public void fetchDataFromDataSource(String fileType, FileType.FileTypeBuilder fileTypeBuilder) {
        Document document = HTMLUtil.getDocumentByURL(URLUtil.getURL(dataSource.getUrl(), fileType));
        if(document == null)
            return;
        Element result = document.body().getElementById("result");
        if (result != null && result.child(0) != null) {
            result = result.child(0);
            fileTypeBuilder.setFileTypeName(result.getElementById("ext0").text());
            for (Element element : result.children()) {
                if (element.getElementsByTag("span").text().toLowerCase().startsWith("description")) {
                    fileTypeBuilder.setShortDescription(element.text().replaceAll("Description:", "").trim());
                } else if (element.getElementsByTag("span").text().toLowerCase().startsWith("category")) {
                    fileTypeBuilder.setCategory(element.text().replaceAll("Category:", "").trim());
                } else if (element.getElementsByTag("span").text().toLowerCase().contains("aliases")) {
                    fileTypeBuilder.addAliasExtensions(element.nextElementSibling().text().trim().split(","));
                } else if (element.getElementsByTag("span").text().toLowerCase().startsWith("mime-type")) {
                    fileTypeBuilder.addMimeType(element.text().replaceAll("Mime-type:", "").trim());
                }
            }
            result.getElementsByClass("relext").forEach(element -> {
                fileTypeBuilder.addRelatedExtensions(element.text());
            });
        }
    }
}
