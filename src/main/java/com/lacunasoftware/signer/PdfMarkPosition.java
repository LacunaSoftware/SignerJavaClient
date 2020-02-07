package com.lacunasoftware.signer;


public class PdfMarkPosition {
	private int page;
	private double topLeftX;
	private double topLeftY;
	private double width;
	private double height;

	PdfMarkPosition(LacunaSignerApiSignaturePdfMarkPosition model) {
		this.page = model.getPage();
		this.topLeftX = model.getTopLeftX();
		this.topLeftY = model.getTopLeftY();
		this.width = model.getWidth();
		this.height = model.getHeight();
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public double getTopLeftX() {
		return topLeftX;
	}

	public void setTopLeftX(double topLeftX) {
		this.topLeftX = topLeftX;
	}

	public double getTopLeftY() {
		return topLeftY;
	}

	public void setTopLeftY(double topLeftY) {
		this.topLeftY = topLeftY;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	LacunaSignerApiSignaturePdfMarkPosition toModel() {
		LacunaSignerApiSignaturePdfMarkPosition model = new LacunaSignerApiSignaturePdfMarkPosition();
		model.setPage(page);
		model.setTopLeftX(topLeftX);
		model.setTopLeftY(topLeftY);
		model.setWidth(width);
		model.setHeight(height);
		return model;
	}
}
