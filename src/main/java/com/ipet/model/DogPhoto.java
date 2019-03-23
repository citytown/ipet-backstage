package com.ipet.model;

/**
 * 
 * @author Administrator
 * @Func 狗照片实体
 *
 */
public class DogPhoto {

		//id
		private String  id;
		//品种
		private String dogId;
		//原产地
		private String name;
		//体型
		private String url;
		//是否是封面
		private int isCover;
		//照片类型，永久还是暂时
		private int type;
		
	
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getDogId() {
			return dogId;
		}
		public void setDogId(String dogId) {
			this.dogId = dogId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public int getIsCover() {
			return isCover;
		}
		public void setIsCover(int isCover) {
			this.isCover = isCover;
		}
		
		
		public int getType() {
			return type;
		}
		public void setType(int type) {
			this.type = type;
		}
		
		
		
		public DogPhoto(){
			
		}
		public DogPhoto(String id, String dogId, String name, String url, int isCover, int type) {
			super();
			this.id = id;
			this.dogId = dogId;
			this.name = name;
			this.url = url;
			this.isCover = isCover;
			this.type = type;
		}
		
		
		
}
