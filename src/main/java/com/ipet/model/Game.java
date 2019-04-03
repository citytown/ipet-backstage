package com.ipet.model;

/**
 * 
 * @author Administrator
 * @Func 游戏实体类
 *
 */
public class Game {

	private int id;
	//题目
	private String content;
	//照片url
	private String photoUrl;
	//选项一
	private String choiceOne;
	//选项二
	private String choiceTwo;
	//选项三
	private String choiceThree;
	//选项四
	private String choiceFour;
	//正确选项
	private String rightChoice;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	public String getChoiceOne() {
		return choiceOne;
	}
	public void setChoiceOne(String choiceOne) {
		this.choiceOne = choiceOne;
	}
	public String getChoiceTwo() {
		return choiceTwo;
	}
	public void setChoiceTwo(String choiceTwo) {
		this.choiceTwo = choiceTwo;
	}
	public String getChoiceThree() {
		return choiceThree;
	}
	public void setChoiceThree(String choiceThree) {
		this.choiceThree = choiceThree;
	}
	public String getChoiceFour() {
		return choiceFour;
	}
	public void setChoiceFour(String choiceFour) {
		this.choiceFour = choiceFour;
	}
	public String getRightChoice() {
		return rightChoice;
	}
	public void setRightChoice(String rightChoice) {
		this.rightChoice = rightChoice;
	}
	
	public Game(){
		
	}
	public Game(String content, String photoUrl, String choiceOne, String choiceTwo, String choiceThree,
			String choiceFour, String rightChoice) {
		super();
		this.content = content;
		this.photoUrl = photoUrl;
		this.choiceOne = choiceOne;
		this.choiceTwo = choiceTwo;
		this.choiceThree = choiceThree;
		this.choiceFour = choiceFour;
		this.rightChoice = rightChoice;
	}
	
	
	
}
