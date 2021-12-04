package com.course.movie.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.course.movie.dto.UserDto;
import com.course.movie.dto.UserRoleDto;
import com.course.movie.model.Role;
import com.course.movie.model.User;
import com.course.movie.model.UserRole;
import com.course.movie.model.UserRoleKey;
import com.course.movie.repository.RoleRepository;
import com.course.movie.repository.UserRepository;
import com.course.movie.repository.UserRoleRepository;



@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserRoleRepository userRoleRepository;

	
	public User insert(UserDto userDto) {
		return userRepository.save(createUserFromDto(userDto));
	}

	public Optional<User> findById(int id) throws NotFoundException {
		return userRepository.findById(id);
		}

	public User update(User user)  {
		if (userRepository.existsById(user.getUserID())) {
			return userRepository.save(user);
		}
//		throw new NotFoundException("Nije pronaÄ‘en Å¾anr sa id-em:" + genre.getGenreId());
		else {
			return user;	
		}
	}
   
	public void delete(int userId) throws NotFoundException {
		if (userRepository.existsById(userId)) {
			userRepository.deleteById(userId);
		} else {
//			throw new NotFoundException("Nije pronaÄ‘en Å¾anr sa id-em:" + genreId);
			
		}
	}

	public List<User> getAll() {
		return userRepository.findAll();
	}
    public User getByUserName (String userName){
    	
    	     return userRepository.getByUserName(userName);
    		
    }
    public User getByEmail (String email){
    	
	     return userRepository.getByEmail(email);
		
}
	private User createUserFromDto(UserDto userDto) {

		User user = new User();
		
		// should be unique field
		if(userRepository.getByUserName(userDto.getUserName()) == null && userRepository.getByEmail(userDto.getEmail())==null) {
			user.setUserName(userDto.getUserName());
			user.setActive(userDto.getActive());
			user.setAddress(userDto.getAddress());
			// should be unique
			//List<User> users=new ArrayList<User>();
			user.setEmail(userDto.getEmail());
			user.setFirstName(userDto.getFirstName());
			user.setLastName(userDto.getLastName());
			return user;
		}
		else	
			throw new NullPointerException("Username or email are used!");
		
	}

	public UserRole addRole(UserRoleDto userRoleDto) {
		// TODO Auto-generated method stub
		User user = new User();
		user=this.userRepository.getById(userRoleDto.getUserID());
		Role role= new Role();
		role=this.roleRepository.getById(userRoleDto.getRoleID());
		UserRoleKey novi=new UserRoleKey();
		novi.setRoleID(userRoleDto.getRoleID());
		novi.setUserID(userRoleDto.getUserID());
		this.userRoleRepository.save(new UserRole(novi,role,user));
		return new UserRole(novi,role,user);
	}
	
	
}
