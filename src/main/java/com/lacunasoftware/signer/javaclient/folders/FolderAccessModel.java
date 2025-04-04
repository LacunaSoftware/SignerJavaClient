package com.lacunasoftware.signer.javaclient.folders;

import java.util.List;
import java.util.UUID;

import com.google.gson.annotations.SerializedName;

public class FolderAccessModel {
	public enum Roles {
	@SerializedName("Admin")
	ADMIN("Admin"),
	@SerializedName("Manager")
	MANAGER("Manager"),
	@SerializedName("Basic")
	BASIC("Basic");

		private String value;

		Roles(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}

	private UUID id;
	private UUID userId;
	private List<Roles> folderRoles;
	private List<Roles> organizationRoles;
	private String userName;
	private String userIdentifier;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public List<Roles> getFolderRoles() {
		return folderRoles;
	}

	public void setFolderRoles(List<Roles> folderRoles) {
		this.folderRoles = folderRoles;
	}

	public List<Roles> getOrganizationRoles() {
		return organizationRoles;
	}

	public void setOrganizationRoles(List<Roles> organizationRoles) {
		this.organizationRoles = organizationRoles;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserIdentifier() {
		return userIdentifier;
	}

	public void setUserIdentifier(String userIdentifier) {
		this.userIdentifier = userIdentifier;
	}
}