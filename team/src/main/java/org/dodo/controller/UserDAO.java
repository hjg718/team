package org.dodo.controller;

import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO {

	
	// Mapper.xml ������ boolean�� �� �� ����?? �׷��Ƿ� �ڷ����� int�� �Ѵ�.
	public UserVO login(String id);
	public int join(UserVO user);
	
}
