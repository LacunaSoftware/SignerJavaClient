package com.lacunasoftware.signer.javaclient.builders;

import com.lacunasoftware.signer.FileUploadModel;
import com.lacunasoftware.signer.attachments.AttachmentUploadModel;
import com.lacunasoftware.signer.javaclient.models.UploadModel;

public class AttachmentUploadBuilder extends UploadModel {


    private String displayName;
    private String key;
    private Boolean isPrivate;

    public AttachmentUploadBuilder(UploadModel uploadModel) {
        id = uploadModel.getId();
        name = uploadModel.getName();
        contentType = uploadModel.getContentType();
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Boolean getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(Boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public AttachmentUploadModel toModel() {
        AttachmentUploadModel model = new AttachmentUploadModel();
        model.setId(id);
        model.setName(name);
        model.setContentType(contentType);
        model.setDisplayName(displayName);
        model.setIsPrivate(isPrivate);
        return model;
    }

}