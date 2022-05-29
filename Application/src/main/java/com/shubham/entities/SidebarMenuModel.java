package com.shubham.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection = "sidebarmenu_mst")
@Entity
public class SidebarMenuModel {

	public String getId() {
		return id.toHexString();
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public SidebarMenuModel(String menuName, String menuUrl, String menuImage) {
		this.menuName = menuName;
		this.menuUrl = menuUrl;
		this.menuImage = menuImage;
	}

	public SidebarMenuModel(ObjectId id, String menuName, String menuUrl, String menuImage, boolean menuStatusFlag) {
		this.id = id;
		this.menuName = menuName;
		this.menuUrl = menuUrl;
		this.menuImage = menuImage;
		this.menuStatusFlag = menuStatusFlag;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private ObjectId id;

	@Indexed(unique = true, sparse = true)
	private String menuName;
	private String menuUrl;
	private String menuImage;
	private boolean menuStatusFlag = true;

}
