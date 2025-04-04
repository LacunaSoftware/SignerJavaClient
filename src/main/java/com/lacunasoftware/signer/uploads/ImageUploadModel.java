package com.lacunasoftware.signer.uploads;
import com.google.gson.annotations.SerializedName;

public class ImageUploadModel {
    @SerializedName("id")
    public String Id;

    @SerializedName("contentType")
    public String ContentType;
    
    @SerializedName("save")
    public boolean Save;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getContentType() {
        return ContentType;
    }

    public void setContentType(String contentType) {
        ContentType = contentType;
    }

    public boolean isSave() {
        return Save;
    }

    public void setSave(boolean save) {
        Save = save;
    }
}

    