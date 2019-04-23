package com.dangducluan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dangducluan.entities.Blog;
import com.dangducluan.entities.Post;
import com.dangducluan.entities.User;
import com.dangducluan.mapper.BlogMapper;
import com.dangducluan.mapper.UserMapper;

@Controller
@RequestMapping(path = "/")
public class HomeController {
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	BlogMapper blogMapper;
	
	@GetMapping
	@ResponseBody
	public String Default()
	{
		List<User> listUser = userMapper.getAllUsers();
		User user = listUser.get(0);
		System.out.println(user.getEmailId());
		Blog blog = user.getBlog();
		System.out.println("Name blog : "+blog.getBlogName());
		return "Hello";
	}
	@GetMapping(path = "/{userId}")
	@ResponseBody
	public String getInfoUserById(@PathVariable int userId)
	{
		User user = userMapper.getUserById(userId);
		System.out.println("Name user : "+user.getEmailId());
		return "Hello 2";
	}
	@GetMapping(path = "/getlistblog")
	@ResponseBody
	public String getInfoBlog()
	{
		List<Blog> listBlog = blogMapper.getAllBlogs();
		List<Post> listPost = listBlog.get(0).getListPost();
		for(Post x : listPost)
		{
			System.out.println(x.getTitle());
		}
		return "Hello 3";
	}
}
