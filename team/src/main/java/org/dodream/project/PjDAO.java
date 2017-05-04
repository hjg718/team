package org.dodream.project;


import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.userdetails.User;


public interface PjDAO {
	

	public int input(PjVO vo);
	
	public boolean join(UserVO vo);
	
	public PjVO getRecent(String userId);
		
	public ArrayList<FileVO> getFrecent(String UserId);
	
	public ArrayList<PjVO> getList();
	
	public PjV getPage(int page);
	
	public PjVO getRead(int num);
	
	public ArrayList<FileVO> getFread(int num);
	
	public ArrayList<PjVO> getFind(@Param("keyword")String keyword,@Param("category")String cat);
	
	public int Modify(PjVO vo);
	
	public int delete(int num);
	
	public int reple(PjVO vo);
	
	public int fileUP(FileVO vo);
	
	public User getUser(String userId);
	
	
	
	
}
