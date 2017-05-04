package org.dodream.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PjController {

	@Autowired
    private PjService svc;
	@Autowired
	SqlSessionTemplate sqlSessionTmplate;
	

		
	@RequestMapping(value="join",method=RequestMethod.GET)
	public String joinF(){
		return "pj/joinform";
	}
		
	@RequestMapping(value="join",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Boolean> JoinF(UserVO vo){
		Map<String, Boolean> map = new HashMap<String,Boolean>();
		map.put("save", svc.join(vo));
		return map;
		}
	
	@RequestMapping(value = "recent", method = RequestMethod.GET)
    public String getUserRecentPost(PjVO user,Model model,HttpSession session){
    	String userId = (String)session.getAttribute("userId");
    	model.addAttribute("recent",svc.getRecent(userId));
    	return "pj/recent";
    }
		

	@RequestMapping(value="list", method = RequestMethod.GET)
	public String getList(PjVO vo, Model model,HttpSession session){
		ArrayList<PjVO> list = svc.getList();
		model.addAttribute("list",list);
		session.setAttribute("curr",1);
		session.setAttribute("total",list.get(0).getTotalpages());
		return "pj/list";
		
	}
	
	@RequestMapping(value="page", method=RequestMethod.POST)
	@ResponseBody
	public String getPage(@RequestParam("pgnum") int pgnum){
		String list = svc.getPage(pgnum);
		return list;
	}
	
	@RequestMapping(value="read",method=RequestMethod.GET)
	public String getRead(@RequestParam("num")int num, Model model){
		PjV pj = svc.Read(num);
		model.addAttribute("pj",pj);
		return "pj/read";
	}
	
	@RequestMapping(value="find",method=RequestMethod.POST)
	@ResponseBody
	public String getFind(@RequestParam("keyword") String keyword ,@RequestParam("category")String cat, HttpSession session){
		String list = svc.Find(keyword,cat);
		return list;
	}
	
	@RequestMapping("modify")
	public String ModifyF(){
		return "pj/modify";
	}
	
	@RequestMapping(value="modify",method=RequestMethod.POST)
	@ResponseBody
	public int getModify(PjVO vo,HttpSession session){
		int mo = svc.Modify(vo, session);
		return mo;
	}
	
	@RequestMapping(value="delete",method=RequestMethod.POST)
	@ResponseBody
	public String Delete(@RequestParam("num")int num){
		String del = svc.Delete(num);
		return del;
	}
	
	@RequestMapping(value="reple",method=RequestMethod.POST)
	@ResponseBody
	public String reple(PjVO vo,HttpSession session){
		session.setAttribute("userId",vo.getAuthor());
		String re = svc.input(vo);
		return re;
	}
	
	@RequestMapping(value="fileup",method=RequestMethod.GET)
	public String fileF(){
		return "pj/input";
	}
	
	@RequestMapping(value="fileup",method=RequestMethod.POST)
	public String file(PjVO vo,Model model){
		svc.fileUp(vo);
		PjV pj = svc.getRecent(vo.getAuthor());
		model.addAttribute("pj",pj);
		return "pj/recent";
	}
	
	@RequestMapping(value="down",method=RequestMethod.POST)
	@ResponseBody
	 public byte[] getImage(HttpServletResponse response,
	            @RequestParam("fname1") String fname1, @RequestParam("fname2") String fname2) throws IOException
	 {
		System.out.println(fname1);
		System.out.println(fname2);
	    File file = new File("D:/JavaTest"+fname2);
	        byte[] bytes = org.springframework.util.FileCopyUtils.copyToByteArray(file);
	  
	    String fn = new String(fname1.getBytes("utf-8"), "iso_8859_1");
	  
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fn + "\"");
	    response.setContentLength(bytes.length);
	    response.setContentType("image/jpeg");
	  
	    return bytes;
	 }
	
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String loginF(){
		return "pj/loginForm";
	}

	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(@RequestParam("id") String id){
		return "pj/loginForm";
}
	
	@RequestMapping(value="logout",method=RequestMethod.GET)
	public String logout(){
		return "pj/logout";
		}
	
    
}
