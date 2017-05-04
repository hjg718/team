package org.dodream.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;

@Service
public class PjService {
	

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public boolean join(UserVO vo) {
		PjDAO dao = sqlSessionTemplate.getMapper(PjDAO.class);
		return dao.join(vo);
	}

	public String input(PjVO vo) {
		PjDAO dao = sqlSessionTemplate.getMapper(PjDAO.class);
		JSONObject job = new JSONObject();
		int input = dao.input(vo);
		boolean ok;
		if (input == 0) {
			ok = false;
		} else {
			ok = true;
		}
		job.put("save", ok);
		return job.toJSONString();
	}

	public PjV getRecent(String userId) {
		PjDAO dao = sqlSessionTemplate.getMapper(PjDAO.class);
		ArrayList<FileVO> fvo = dao.getFrecent(userId);
		PjVO vo = dao.getRecent(userId);
		PjV pj = new PjV();
		pj.setVo(vo);
		pj.setFlist(fvo);
		
		return pj; 

	}

	public ArrayList<PjVO> getList() {
		PjDAO dao = sqlSessionTemplate.getMapper(PjDAO.class);
		return dao.getList();
	}

	public String getPage(int page) {
		PjDAO dao = sqlSessionTemplate.getMapper(PjDAO.class);
		JSONArray jarr = new JSONArray();
		PjV list = dao.getPage(page);
		for (int i = 0; i < list.getList().size(); i++) {
			JSONObject ojb = new JSONObject();
			ojb.put("title", list.getList().get(i).getTitle());
			ojb.put("num", list.getList().get(i).getNum());
			ojb.put("author", list.getList().get(i).getAuthor());
			jarr.add(ojb);
		}
		return jarr.toJSONString();

	}

	public PjV Read(int num) {
		PjDAO dao = sqlSessionTemplate.getMapper(PjDAO.class);
		ArrayList<FileVO> fvo = dao.getFread(num);
		PjVO vo = dao.getRead(num);
		PjV pj = new PjV();
		pj.setVo(vo);
		pj.setFlist(fvo);
		return pj;
	}

	public String Find(String keyword, String cat) {
		PjDAO dao = sqlSessionTemplate.getMapper(PjDAO.class);
		JSONArray jarr = new JSONArray();
		ArrayList<PjVO> list = dao.getFind(keyword, cat);
		for (int i = 0; i < list.size(); i++) {
			JSONObject job = new JSONObject();
			job.put("title", list.get(i).getTitle());
			job.put("author", list.get(i).getAuthor());
			job.put("num", list.get(i).getNum());
			jarr.add(job);
		}

		return jarr.toJSONString();
	}

	public int Modify(PjVO vo, HttpSession session) {
		PjDAO dao = sqlSessionTemplate.getMapper(PjDAO.class);
		session.setAttribute("userId", vo.getAuthor());
		Map<String, Boolean> map = new HashMap<>();
		int mod = dao.Modify(vo);
		boolean ok;
		if (mod == 0) {
			ok = false;
		} else {
			ok = true;
		}
		map.put("save", ok);
		return dao.Modify(vo);
	}

	public String Delete(int num) {
		PjDAO dao = sqlSessionTemplate.getMapper(PjDAO.class);
		int del = dao.delete(num);
		JSONObject job = new JSONObject();
		boolean ok = false;
		if (del > 0) {
			ok = true;
			job.put("del", ok);
		}
		return job.toJSONString();
	}

	public boolean fileUp(PjVO vo) {
		
		PjDAO dao = sqlSessionTemplate.getMapper(PjDAO.class);
		int put = dao.input(vo);
		boolean ok = false;
		if (put == 0) {
			return ok;
		}
		for (int i = vo.getFiles().size() - 1; i >= 0; i--) {
			MultipartFile files = vo.getFiles().get(i);
			if (files.getSize() == 0) {
				vo.getFiles().remove(i);
				continue;
			}

			FileVO fvo = new FileVO();
			fvo.setOwner(vo.getAuthor());
			String fname = files.getOriginalFilename();
			fvo.setFname1(fname);
			fvo.setDesc(vo.getDesc());
			String same = fname;
			File file = new File("D:/JavaTest/file");
			String[] list = file.list();
			for (int j = 0; j < list.length; j++) {
				if (list[j].equals(fname)) {
					String tmp = fname.split("\\.")[0];
					String ext = fname.split("\\.")[1];
					tmp += new Date().getTime() + "." + ext;
					same = tmp;
				}
			}
			fvo.setFname2(same);
			fvo.setFsize(files.getSize());
			InputStream iput = null;
			OutputStream oput = null;
			try {
				iput = files.getInputStream();
				File file1 = new File("D:/JavaTest/file/" + same);
				oput = new FileOutputStream(file1);
				byte[] buf = new byte[9999];
				int read = 0;
				while ((read = iput.read(buf)) != -1) {
					oput.write(buf, 0, read);
					oput.flush();
				}
				if (dao.fileUP(fvo) <= 0)
				return false;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					iput.close();
					oput.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return true;
	}

	
}
