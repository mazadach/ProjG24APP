package com.example.projg24app.content.slidedrawer;


public class SlideDrawerModel {
	
	private int imageView;
	private String text;
	
	public SlideDrawerModel(int imageView, String text) {
		this.imageView = imageView;
		this.text = text;
	}

	public int getImageView() {
		return imageView;
	}

	public void setImageView(int imageView) {
		this.imageView = imageView;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
