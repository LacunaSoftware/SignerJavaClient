package com.lacunasoftware.signer.javaclient.builders;

import com.lacunasoftware.signer.FileUploadModel;
import com.lacunasoftware.signer.attachments.AttachmentUploadModel;
import com.lacunasoftware.signer.javaclient.models.UploadModel;

public class FileUploadModelBuilder extends UploadModel {

    private String displayName;
    private String key;

    public FileUploadModelBuilder(UploadModel uploadModel) {
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
        this.displayName = displayName;
    }
    
    public FileUploadModel toModel() {
        FileUploadModel model = new FileUploadModel();
        model.setId(id);
        model.setName(name);
        model.setContentType(contentType);
        model.setDisplayName(displayName);
        return model;
    }


    public AttachmentUploadModel toAttachmentModel(FileUploadModelBuilder uploadModel){
        AttachmentUploadModel attachmentUploadModel = new AttachmentUploadModel();
        attachmentUploadModel.setDisplayName(uploadModel.getDisplayName());
        attachmentUploadModel.setId(uploadModel.getId());
        attachmentUploadModel.displayName(uploadModel.getName());
        attachmentUploadModel.setContentType(uploadModel.getContentType());
        return attachmentUploadModel;

    }
}
