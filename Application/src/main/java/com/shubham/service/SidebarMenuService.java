package com.shubham.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubham.dao.SidebarMenuRepository;
import com.shubham.entities.SidebarMenuModel;

@Service
public class SidebarMenuService {

	@Autowired
	private SidebarMenuRepository sidebarMenuRepository;

	public String addMenu(SidebarMenuModel menuModel) {
		SidebarMenuModel sidebarMenuModel = new SidebarMenuModel(menuModel.getMenuName(), menuModel.getMenuUrl(),
				menuModel.getMenuImage());
		SidebarMenuModel savedMenu = sidebarMenuRepository.save(sidebarMenuModel);
		return savedMenu.getMenuName();
	}

	public String removeMenu(String menuName) {
		SidebarMenuModel menu = getByMenuName(menuName);
		menu.setMenuStatusFlag(false);
		SidebarMenuModel removed = sidebarMenuRepository.save(menu);
		return removed.getId();
	}

	public List<SidebarMenuModel> getAllMenus() {
		return sidebarMenuRepository.findAll();
	}

	public SidebarMenuModel getByMenuName(String menuName) {
		SidebarMenuModel findByMenuName = sidebarMenuRepository.findByMenuName(menuName);
		return findByMenuName;
	}

	public String updateMenu(SidebarMenuModel menuModel) {
		SidebarMenuModel sidebarMenuModel = new SidebarMenuModel(new ObjectId(menuModel.getId()),
				menuModel.getMenuName(), menuModel.getMenuUrl(), menuModel.getMenuImage(),
				menuModel.isMenuStatusFlag());
		SidebarMenuModel savedMenu = sidebarMenuRepository.save(sidebarMenuModel);
		return savedMenu.getMenuName();
	}
}