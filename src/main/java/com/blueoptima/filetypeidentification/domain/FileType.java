package com.blueoptima.filetypeidentification.domain;

import java.util.*;

/**
 * The @{@link FileType} use to store information about file type.
 *
 * @author Bhavesh Patel
 * @version 1.0
 * @since 2018-03-08
 */
public class FileType {
    private String fileType;
    private String fileTypeName;
    private String shortDescription;
    private String category;
    private Set<String> applications;
    private String languageFamily;
    private String company;
    private String format;
    private Set<String> mimeTypes;
    private Set<String> aliasExtensions;
    private Set<String> relatedExtensions;

    public FileType(String fileType, String fileTypeName, String shortDescription, String category, Set<String> applications, String languageFamily, String company, String format, Set<String> mimeTypes, Set<String> aliasExtensions, Set<String> relatedExtensions) {
        this.fileType = fileType;
        this.fileTypeName = fileTypeName;
        this.shortDescription = shortDescription;
        this.category = category;
        this.applications = applications;
        this.languageFamily = languageFamily;
        this.company = company;
        this.format = format;
        this.mimeTypes = mimeTypes;
        this.aliasExtensions = aliasExtensions;
        this.relatedExtensions = relatedExtensions;
    }

    public String getFileType() {
        return fileType;
    }

    public String getFileTypeName() {
        return fileTypeName;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getCategory() {
        return category;
    }

    public Set<String> getApplications() {
        return applications;
    }

    public String getLanguageFamily() {
        return languageFamily;
    }

    public String getCompany() {
        return company;
    }

    public String getFormat() {
        return format;
    }

    public Set<String> getMimeTypes() {
        return mimeTypes;
    }

    public Set<String> getAliasExtensions() {
        return aliasExtensions;
    }

    public Set<String> getRelatedExtensions() {
        return relatedExtensions;
    }

    @Override
    public String toString() {
        return "FileType{" +
                "fileType='" + fileType + '\'' +
                ", fileTypeName='" + fileTypeName + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", category='" + category + '\'' +
                ", applications='" + applications + '\'' +
                ", languageFamily='" + languageFamily + '\'' +
                ", company='" + company + '\'' +
                ", format='" + format + '\'' +
                ", mimeTypes=" + mimeTypes +
                ", aliasExtensions=" + aliasExtensions +
                ", relatedExtensions=" + relatedExtensions +
                '}';
    }

    /**
     * The @{@link FileTypeBuilder} use to build @{@link FileType}
     *
     * @author Bhavesh Patel
     * @version 1.0
     * @since 2018-03-08
     */
    public static class FileTypeBuilder {
        private String fileType;
        private String fileTypeName;
        private String shortDescription;
        private String category;
        private Set<String> applications;
        private String languageFamily;
        private String company;
        private String format;
        private Set<String> mimeTypes;
        private Set<String> aliasExtensions;
        private Set<String> relatedExtensions;
        public FileTypeBuilder() {
        }

        public FileTypeBuilder(String fileType, String fileTypeName, String shortDescription, String category, Set<String> applications, String languageFamily, String company, String format, Set<String> mimeTypes, Set<String> aliasExtensions, Set<String> relatedExtensions) {
            this.fileType = fileType;
            this.fileTypeName = fileTypeName;
            this.shortDescription = shortDescription;
            this.category = category;
            this.applications = applications;
            this.languageFamily = languageFamily;
            this.company = company;
            this.format = format;
            this.mimeTypes = mimeTypes;
            this.aliasExtensions = aliasExtensions;
            this.relatedExtensions = relatedExtensions;
        }

        public FileTypeBuilder setFileType(String fileType) {
            this.fileType = fileType;
            return this;
        }

        public FileTypeBuilder setFileTypeName(String fileTypeName) {
            this.fileTypeName = fileTypeName;
            return this;
        }

        public FileTypeBuilder setShortDescription(String shortDescription, String dataSource) {
            this.shortDescription = shortDescription;
            return this;
        }

        public FileTypeBuilder setCategory(String category) {
            this.category = category;
            return this;
        }


        public void setApplications(Set<String> applications) {
            this.applications = applications;
        }

        public FileTypeBuilder addApplication(String application) {
            if (this.applications == null)
                this.applications = new HashSet<>();
            this.applications.add(application);
            return this;
        }

        public FileTypeBuilder addApplications(String[] applications) {
            if (this.applications == null)
                this.applications = new HashSet<>();
            this.applications.addAll(Arrays.asList(applications));
            return this;
        }

        public FileTypeBuilder setLanguageFamily(String languageFamily) {
            this.languageFamily = languageFamily;
            return this;
        }

        public FileTypeBuilder setCompany(String company) {
            this.company = company;
            return this;
        }

        public FileTypeBuilder setFormat(String format) {
            this.format = format;
            return this;
        }

        public FileTypeBuilder setMimeTypes(Set<String> mimeTypes) {
            this.mimeTypes = mimeTypes;
            return this;
        }

        public FileTypeBuilder addMimeType(String mimeType) {
            if (this.mimeTypes == null)
                this.mimeTypes = new HashSet<>();
            this.mimeTypes.add(mimeType);
            return this;
        }

        public FileTypeBuilder addMimeType(String[] mimeTypes) {
            if (this.mimeTypes == null)
                this.mimeTypes = new HashSet<>();
            this.mimeTypes.addAll(Arrays.asList(mimeTypes));
            return this;
        }

        public FileTypeBuilder setAliasExtensions(Set<String> aliasExtensions) {
            this.aliasExtensions = aliasExtensions;
            return this;
        }

        public FileTypeBuilder addAliasExtension(String aliasExtension) {
            if (this.aliasExtensions == null)
                this.aliasExtensions = new HashSet<>();
            this.aliasExtensions.add(aliasExtension);
            return this;
        }

        public FileTypeBuilder addAliasExtensions(String[] aliasExtensions) {
            if (this.aliasExtensions == null)
                this.aliasExtensions = new HashSet<>();
            this.aliasExtensions.addAll(Arrays.asList(aliasExtensions));
            return this;
        }

        public FileTypeBuilder setRelatedExtensions(Set<String> relatedExtensions) {
            this.relatedExtensions = relatedExtensions;
            return this;
        }

        public FileTypeBuilder addRelatedExtensions(String relatedExtension) {
            if (this.relatedExtensions == null)
                this.relatedExtensions = new HashSet<>();
            this.relatedExtensions.add(relatedExtension);
            return this;
        }

        public FileTypeBuilder addRelatedExtensions(String[] relatedExtensions) {
            if (this.relatedExtensions == null)
                this.relatedExtensions = new HashSet<>();
            this.relatedExtensions.addAll(Arrays.asList(relatedExtensions));
            return this;
        }

        public FileType build() {
            return new FileType(fileType, fileTypeName, shortDescription, category, applications, languageFamily, company, format, mimeTypes, aliasExtensions, relatedExtensions);
        }

    }
}
