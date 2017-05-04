package org.dodo.controller;

import java.util.*;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Cont {

	
	@Autowired
	private ContService svc;
	
	@RequestMapping("start")
	public String start(){
		return "test/loginForm";
	}
	
	@RequestMapping("joinForm")
	public String joinForm(){
		return "test/joinForm";
	}
	
	@RequestMapping(value="loginPage")
	@ResponseBody
	public String login(@RequestParam("id") String id , Model model,UserVO user){
		boolean ok =  svc.login(id);
		JSONObject job = new JSONObject();
		job.put("login", ok);
		
		return job.toJSONString();
	}
	@RequestMapping(value="join")
	@ResponseBody
	public String join(UserVO user){
		System.out.println("join 메소드 시작");
		boolean ok = svc.join(user);
		JSONObject job = new JSONObject();
		job.put("join", ok);
		return job.toJSONString();
	}
	
}
