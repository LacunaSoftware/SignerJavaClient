package com.lacunasoftware.signer.javaclient.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PaginatedSearchResponse<T> {

	@SerializedName("items")
	private List<T> items;

	@SerializedName("totalCount")
	private Integer totalCount;

	public List<T> getItems() {
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
}