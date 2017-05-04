package org.dodream.project;

import java.util.List;

public class PjV {

	private List<PjVO> list;
	private List<FileVO> flist;
	private PjVO vo;
	private int page;
	private int totalpages;
	
	public List<PjVO> getList() {
		return list;
	}
	public void setList(List<PjVO> list) {
		this.list = list;
	}
	public List<FileVO> getFlist() {
		return flist;
	}
	public void setFlist(List<FileVO> flist) {
		this.flist = flist;
	}
	public PjVO getVo() {
		return vo;
	}
	public void setVo(PjVO vo) {
		this.vo = vo;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalpages() {
		return totalpages;
	}
	public void setTotalpages(int totalpages) {
		this.totalpages = totalpages;
	}
	
	
	
	
}
