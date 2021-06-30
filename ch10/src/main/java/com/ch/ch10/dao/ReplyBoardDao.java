package com.ch.ch10.dao;

import java.util.List;

import com.ch.ch10.model.ReplyBoard;

public interface ReplyBoardDao {
	List<ReplyBoard> list(int bno);

	Object delete(ReplyBoard rb);

	void insert(ReplyBoard rb);

	void update(ReplyBoard rb);
}
