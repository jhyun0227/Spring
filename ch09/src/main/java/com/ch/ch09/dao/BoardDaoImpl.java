package com.ch.ch09.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ch.ch09.model.Board;

@Repository
public class BoardDaoImpl implements BoardDao {
	@Autowired
	private SqlSessionTemplate sst;

//	@Override
//	public List<Board> list(int startRow, int endRow) {
//		Map<String, Integer> map = new HashMap<String, Integer>();
//		map.put("startRow", startRow);
//		map.put("endRow", endRow);
//		return sst.selectList("boardns.list", map);
//	}	
	@Override
	public List<Board> list(Board board) {
		return sst.selectList("boardns.list", board);
	}

//	@Override
//	public int getTotal() {
//		return sst.selectOne("boardns.getTotal");
//	}
	@Override
	public int getTotal(Board board) {
		return sst.selectOne("boardns.getTotal", board);
	}

	@Override
	public int getMaxNum() {
		return sst.selectOne("boardns.getMaxNum");
	}

	@Override
	public int insert(Board board) {
		return sst.insert("boardns.insert", board);
	}

	@Override
	public void updateReadCount(int num) {
		sst.update("boardns.updateReadCount", num);
	}

	@Override
	public Board select(int num) {
		return sst.selectOne("boardns.select", num);
	}

	@Override
	public int update(Board board) {
		return sst.update("boardns.update", board);
	}

	@Override
	public int delete(int num) {
		return sst.update("boardns.delete", num);
		/* return sst.delete("boardns.delete", num); */
	}

	@Override
	public Object updateStep(Board board) {
		return sst.update("boardns.updateStep", board);
	}
}
