package de.fhdw.bfwi412a.geopfad;



public class Ort {
	private String name;
	private String imgUrl;
	private String about;
	private String link;	
	private double latitude;
	private double longitude;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public double getLat() {
		return latitude;
	}
	public void setLat(double latitude) {
		this.latitude = latitude;
	}
	public double getLng() {
		return longitude;
	}
	public void setLng(double longitude) {
		this.longitude = longitude;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}


}
