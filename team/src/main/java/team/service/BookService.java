package team.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import team.book.model.BookDao;
import team.book.model.BookVo;

@Service
public class BookService {

	@Autowired
	private SqlSessionTemplate sqlST;
	
	public List<BookVo> search(String keyword,String category){
		BookDao dao = sqlST.getMapper(BookDao.class);
		List<BookVo> list= dao.search(keyword,category);
		return list;
	}
	
	public boolean insert(BookVo book){
		BookDao dao = sqlST.getMapper(BookDao.class);
		int n = dao.insert(book);
		boolean insert;
		
		if(n>=0){
			insert = true;
		}
		else{
			insert = false;
		}
		return insert;
	}
}
