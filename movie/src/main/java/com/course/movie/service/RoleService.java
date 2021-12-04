package com.course.movie.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.movie.dto.RoleDto;
import com.course.movie.model.Role;
import com.course.movie.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	RoleRepository roleRepository;
	public Role insert(RoleDto roleDto) {
		return roleRepository.save(createRoleFromDto(roleDto));
	}
	private Role createRoleFromDto(RoleDto roleDto) {
	
		// check if the role already exist
		List<Role> roles=new ArrayList<Role>();
		roles=this.roleRepository.findAll();
		Boolean Postoji=false;
		for(int i=0; i<roles.size();i++) {
			Role r=roles.get(i);
			if(r.getName().equals(roleDto.getName())) {
	         //   System.out.println("Role already exist.");
				Postoji=true;
	          
			}
		}
		
		if(!Postoji) {
			Role role = new Role();
			role.setName(roleDto.getName());
			return role;	
		}
		else
			throw new NullPointerException("Role already exist");
	}
}
