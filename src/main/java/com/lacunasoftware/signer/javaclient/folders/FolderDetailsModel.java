package com.lacunasoftware.signer.javaclient.folders;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.UUID;

<<<<<<< HEAD:src/main/java/com/lacunasoftware/signer/LacunaSignerApiFoldersFolderDetailsModel.java

class LacunaSignerApiFoldersFolderDetailsModel {
=======
public class FolderDetailsModel {
>>>>>>> update/signer-java-client:src/main/java/com/lacunasoftware/signer/javaclient/folders/FolderDetailsModel.java

	@SerializedName("id")
	private UUID id;

	@SerializedName("name")
	private String name;

	@SerializedName("folderAccesses")
	private List<FolderAccessModel> folderAccesses;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<FolderAccessModel> getFolderAccesses() {
		return folderAccesses;
	}

	public void setFolderAccesses(List<FolderAccessModel> folderAccesses) {
		this.folderAccesses = folderAccesses;
	}
}