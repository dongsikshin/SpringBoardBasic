package com.study.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.board.model.Board;
import com.study.board.model.BoardDAOMybatis;

//create, read , update ,delete request is here !!!
@Controller
public class BoardController {
	private BoardDAOMybatis boardDAOMybatis;
	public void setBoardDAOMybatis(BoardDAOMybatis boardDAOMybatis) {
		this.boardDAOMybatis = boardDAOMybatis;
	}
	
	
	@RequestMapping("/board/list.do")
	public String selectAll(Model model){ 
		//Model 이란?  비즈니스 로직 수행 후 반환되는 결과물을 담아놓을 객체이며, 
		//Model에 무언가를 담아놓으면 jsp에서도 결과를 접근할 수 있다...
		System.out.println("selectAll method called!!");
		
		//model area : jdbc, mybatis, hibernate&JPA
		//DAO  객체를 이용하여 Business Logic 을 수행하자!! 
		//boardDAOMybatis = new BoardDAOMybatis();
		List list=boardDAOMybatis.selectAll();
		model.addAttribute("list", list);//메모리의 request 스코프영역에 저장!!
		
		System.out.println("조회된 레코드 수는 "+list.size());
		
		return "board/list";
	}
	
	@RequestMapping("/board/write.do")
	public String insert(Board board){	
		
		//데이터베이스에 1건 넣기!!
		boardDAOMybatis.insert(board);
		
		return "redirect:/board/list.do";
	}
	
	
}








