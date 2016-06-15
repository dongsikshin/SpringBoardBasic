package com.study.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//create, read , update ,delete request is here !!!
@Controller
public class BoardController {
	
	@RequestMapping("/board/list.do")
	public String selectAll(){
		System.out.println("selectAll method called!!");
		
		//model area : jdbc, mybatis, hibernate&JPA
		//DAO  객체를 이용하여 Business Logic 을 수행하자!! 
		
		return "board/list";
	}
	
	@RequestMapping("/board/write.do")
	public String insert(){		
		return "redirect:/board/list.do";
	}
	
	
}








