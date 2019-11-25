package com.ExpenseApp1.Project.Controller;

import com.ExpenseApp1.Project.Exception.UserNotFoundException;
import com.ExpenseApp1.Project.Service.IUserService;
import com.ExpenseApp1.Project.pojo.User;



import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;
	
	/* REGISTER USER */
	@PostMapping("/registerUser")
	public ResponseEntity<String> registerUser(@RequestBody User user)
	{
		
		if(user.getPassword().equals(user.getConfirmPassword()))
		{
			return new ResponseEntity<String>(userService.registerUser(user),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("password dosen't match",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	 }
	

	/* LOGIN USER */
	@GetMapping("/loginuser")
	public ResponseEntity<?>loginUser(@RequestBody User user, HttpSession hs)
	{
	try {
	
		User validUser = userService.loginUser(user.getEmail(),user.getPassword());
	      hs.setAttribute("validUser", validUser);
	      return new ResponseEntity<User>(validUser, HttpStatus.OK);
		
	}
	catch(Exception e)
	{
		throw new UserNotFoundException("user not found");
	}
	}
	

	/* USER LIST */
	@GetMapping("/userslist")
	public List<User> usersList()
	{
		return userService.usersList();
	}
	
	

	/* USER BY ID AND NAME */
	@GetMapping("/getUserByIdAndName")
	public User getByUserIdAndUserName(@RequestBody User user)
	{
		Integer id=user.getUserid();
		String name=user.getUsername();
		return userService.getByUserIdAndName(id,name);
		
	}
	
	


}
