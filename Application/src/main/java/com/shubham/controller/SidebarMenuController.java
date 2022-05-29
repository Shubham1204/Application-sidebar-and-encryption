package com.shubham.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shubham.entities.SidebarMenuModel;
import com.shubham.service.SidebarMenuService;

@RestController
@CrossOrigin("*")
@RequestMapping("/menus/sidebar")
public class SidebarMenuController {

	@Autowired
	private SidebarMenuService menuService;

	@PostMapping("/add")
	public ResponseEntity<?> addMenu(@RequestBody SidebarMenuModel menuModel) {
		String saved = menuService.addMenu(menuModel);
		return ResponseEntity.ok(saved);
	}

	@GetMapping("/get/all")
	public ResponseEntity<?> getAllMenus() {
		List<SidebarMenuModel> allMenus = menuService.getAllMenus();
		return ResponseEntity.ok(allMenus);
	}

	@GetMapping("/get/name/{menuName}")
	public ResponseEntity<?> getByMenuName(@PathVariable("menuName") String menuName) {
		SidebarMenuModel menu = menuService.getByMenuName(menuName);
		return ResponseEntity.ok(menu);
	}

	@PatchMapping("/remove")
	public ResponseEntity<?> removeByMenuName(@RequestBody SidebarMenuModel menuModel) {
		String removedMenuId = menuService.removeMenu(menuModel.getMenuName());
		return ResponseEntity.ok(removedMenuId);
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateMenu(@RequestBody SidebarMenuModel menuModel) {
		String saved = menuService.updateMenu(menuModel);
		return ResponseEntity.ok(saved);
	}

}
