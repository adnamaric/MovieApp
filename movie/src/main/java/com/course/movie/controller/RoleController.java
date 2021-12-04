package com.course.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.movie.dto.MovieRoleDto;
import com.course.movie.dto.RoleDto;
import com.course.movie.model.MovieRole;
import com.course.movie.model.Role;
import com.course.movie.repository.RoleRepository;
import com.course.movie.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {
	@Autowired
	RoleService roleService;
	@Autowired
	RoleRepository roleRepository;
	 @PostMapping("/add")
		public Role insert(@RequestBody RoleDto roleDto) throws NotFoundException {
			return roleService.insert(roleDto);
		}
	 @GetMapping("/all")
	  public List<Role> findAll(){
	        return roleRepository.findAll();
	   }
}
