package org.dodo.controller;

import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO {

	
	// Mapper.xml 에서는 boolean을 줄 수 없다?? 그러므로 자료형은 int로 한다.
	public UserVO login(String id);
	public int join(UserVO user);
	
}
