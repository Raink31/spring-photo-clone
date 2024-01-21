package org.karmelcafe.photoclone.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;

public class Photo {

    // Photo's id
    private String id;

    // Photo's name
    @NotEmpty
    private String fileName;

    private String contentType;

    // Contains the photo's data. @JsonIgnore makes the bytes data disappear on the page
    @JsonIgnore
    private byte[] data;

    // Empty Photo Constructor
    public Photo() {
    }

    // Photo Constructor id and fileName
    public Photo(String id, String fileName) {
        this.id = id;
        this.fileName = fileName;
    }

    // Raw data


    // Getter and Setter for data
    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    // Getter & Setter for id
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    // Getter & Setter for contentType
    public String getContentType() {
        return contentType;
    }
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    // Getter & Setter for fileName
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
