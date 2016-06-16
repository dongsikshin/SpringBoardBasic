package com.study.board.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.config.MybatisConfig;

//for logic but only CRUD !! ( web, android, application)
public class BoardDAOMybatis {
	MybatisConfig mybatisConfig=MybatisConfig.getInstance();
	
	public List selectAll(){
		SqlSession session=mybatisConfig.getSession();
		return session.selectList("Board.selectAll");
		
	}
	
	//한건 등록 메서드 
	public void insert(Board board){
		SqlSession session = mybatisConfig.getSession();
		
		session.insert("Board.insert", board);
		session.commit();
	}
	
	
}










