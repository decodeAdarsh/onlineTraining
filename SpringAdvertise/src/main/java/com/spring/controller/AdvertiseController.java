package com.spring.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.spring.json.Advertise;
import com.spring.json.User;
import com.spring.service.AdvertiseService;
import com.spring.service.UserService;

@RestController
@RequestMapping("/myapp")
public class AdvertiseController 
{
	@Autowired
	private AdvertiseService registrationService;
	
	@PostMapping(value="/advertise", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Object  postAdvertise(@RequestBody Advertise advertise,@RequestHeader(name="auth-token") String authToken)
	{
		return registrationService.save(advertise,authToken);
	}
	@PostMapping(value="/advertise/{id}", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Object  updateAdvertise(@RequestBody Advertise advertise,@RequestHeader(name="auth-token") String authToken,@PathVariable(value="id") String id)
	{
	  return registrationService.update(advertise,authToken,id);
	}
	@GetMapping("/advertise/user")
	public List<Advertise> getAdvertiseBySessionId(@RequestHeader(name="auth-token") String authToken) {
		return registrationService.getAdvertiseBySessionId(authToken);
	}
	@GetMapping("/advertise/user/{postId}")
	public List<Advertise> getAdvertiseByPostId(@RequestHeader(name="auth-token") String authToken,@PathVariable(value="postId") String postId) {
		return registrationService.getAdvertiseByPostId(authToken,postId);
	}
	@DeleteMapping("/advertise/user/{postId}")
	public boolean deleteAdvertiseByPostId(@RequestHeader(name="auth-token") String authToken,@PathVariable(value="postId") String postId) {
		return registrationService.deleteAdvertiseByPostId(authToken,postId);
	}
	@GetMapping("/advertise/searchText/{searchText}")
	public List<Advertise> getAdvertiseBySearchText(@PathVariable(value="searchText") String searchText)
	{
		return registrationService.getAdvertiseBySearchText(searchText);
	}
	@GetMapping("/advertise/category/{category}")
	public List<Advertise> getAdvertiseByCategory(@PathVariable(value="category") String category)
	{
		return registrationService.getAdvertiseByCategory(category);
	}
	@GetMapping("/advertise/postedBy/{name}")
	public List<Advertise> getAdvertiseByName(@PathVariable(value="name") String name)
	{
		return registrationService.getAdvertiseByName(name);
	}
	@GetMapping("/advertise/PostId/{postId}")
	public Advertise getAdvertiseByPostId(@PathVariable(value="postId") String postId)
	{
		return registrationService.getAdvertiseByPostId(postId);
	}
	@GetMapping("/advertise/category")
	public List<String> getAllCategory()
	{
		return registrationService.getAllCategory();
	}
	@GetMapping("/advertiseList")
	public List<Advertise> getAllAdvertise()
	{
		return registrationService.getAllAdvertise();
	}
	
	
}
