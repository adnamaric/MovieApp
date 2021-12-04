package com.course.movie.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.course.movie.dto.UserDto;
import com.course.movie.dto.UserRoleDto;
import com.course.movie.model.User;
import com.course.movie.model.UserRole;
import com.course.movie.repository.UserRepository;
import com.course.movie.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserRepository userRepository;
	@Autowired 
	UserService userService;
	 @GetMapping("/all")
	  public List<User> findAll(){
	        return userRepository.findAll();
	   }
	
	 @PostMapping("/add")
		public User insert(@RequestBody UserDto userDto) throws NotFoundException {
			return userService.insert(userDto);
		}

		@PutMapping("/update")
		public User update(@RequestBody User user) throws NotFoundException {
			return userService.update(user);
		}

		@DeleteMapping("/delete")
		public void delete(@RequestParam int id) throws NotFoundException {
			userService.delete(id);
		}
		@GetMapping("/getByUserName")
		public User getByUserName (@RequestParam String userName) throws NotFoundException {
			
			return userService.getByUserName(userName);
		}
		@GetMapping("/getByEmail")
		public User getByEmail (@RequestParam String email) throws NotFoundException {
			
			return userService.getByEmail(email);
		}
		 @PostMapping("/addRole")
			public UserRole addRole(@RequestBody UserRoleDto userRoleDto) throws NotFoundException {
				return userService.addRole(userRoleDto);
			}
}
