package com.shubham.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.shubham.entities.SidebarMenuModel;

@Repository
public interface SidebarMenuRepository  extends MongoRepository<SidebarMenuModel, Integer>{

	SidebarMenuModel findByMenuName(String menuName);

}
