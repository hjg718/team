package org.dodo.controller;


import java.util.*;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ContService {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	public boolean login(String id) {
		UserDAO dao = sqlSessionTemplate.getMapper(UserDAO.class);
		UserVO list =dao.login(id);
		Boolean ok = false;
		if(list.getId().equals(id)){
			ok = true;
		}
		return ok;
	}

	public boolean join(UserVO user) {
		UserDAO dao = sqlSessionTemplate.getMapper(UserDAO.class);
		int n = dao.join(user);
		boolean ok =false;
		if (n > 0){
			ok = true;
		}
		return ok;
	}

}
