package org.karmelcafe.photoclone.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

// Map the java class to the database table
@Table("PHOTO")
public class Photo {

    // Photo's id
    @Id
    private Integer id;

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

    // Raw data


    // Getter and Setter for data
    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
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
