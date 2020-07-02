package com.lacunasoftware.signer.reserveds;

import com.lacunasoftware.signer.FileUploadModel;

public class FileUploadModelBuilder extends UploadModel {

    private String displayName;

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
    
    public FileUploadModel toModel() {
        FileUploadModel model = new FileUploadModel();
        model.setId(id);
        model.setName(name);
        model.setContentType(contentType);
        model.setDisplayName(displayName);
        return model;
    }
}
