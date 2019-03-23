package com.ipet.model;

import java.util.List;

/**
 * 
 * @author Administrator
 * @Func 狗实体类查询
 *
 */
public class DogParams {

	//id
	private String  id;
	//品种
	private String breed;
	//原产地
	private String original;
	//体型
	private String shape;
	//毛长
	private String woolLength;
	//功能
	private String function;
	//平均情况最短寿命
	private float minLife;
	//平均情况最长寿命
	private float maxLife;
	//平均情况最小价格
	private float minPrice;
	//平均情况最大价格
	private float maxPrice;
	//介绍
	private String description;
	//狗照片ids
	private List<String> photoIds;

	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public String getOriginal() {
		return original;
	}
	public void setOriginal(String original) {
		this.original = original;
	}
	public String getShape() {
		return shape;
	}
	public void setShape(String shape) {
		this.shape = shape;
	}
	public String getWoolLength() {
		return woolLength;
	}
	public void setWoolLength(String woolLength) {
		this.woolLength = woolLength;
	}
	public String getFunction() {
		return function;
	}
	public void setFunction(String function) {
		this.function = function;
	}
	public float getMinLife() {
		return minLife;
	}
	public void setMinLife(float minLife) {
		this.minLife = minLife;
	}
	public float getMaxLife() {
		return maxLife;
	}
	public void setMaxLife(float maxLife) {
		this.maxLife = maxLife;
	}
	public float getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(float minPrice) {
		this.minPrice = minPrice;
	}
	public float getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(float maxPrice) {
		this.maxPrice = maxPrice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<String> getPhotoIds() {
		return photoIds;
	}
	public void setPhotoIds(List<String> photoIds) {
		this.photoIds = photoIds;
	}
	public DogParams(){
		
	}
}
