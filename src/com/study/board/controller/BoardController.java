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
		//Model �̶�?  ����Ͻ� ���� ���� �� ��ȯ�Ǵ� ������� ��Ƴ��� ��ü�̸�, 
		//Model�� ���𰡸� ��Ƴ����� jsp������ ����� ������ �� �ִ�...
		System.out.println("selectAll method called!!");
		
		//model area : jdbc, mybatis, hibernate&JPA
		//DAO  ��ü�� �̿��Ͽ� Business Logic �� ��������!! 
		//boardDAOMybatis = new BoardDAOMybatis();
		List list=boardDAOMybatis.selectAll();
		model.addAttribute("list", list);//�޸��� request ������������ ����!!
		
		System.out.println("��ȸ�� ���ڵ� ���� "+list.size());
		
		return "board/list";
	}
	
	@RequestMapping("/board/write.do")
	public String insert(Board board){	
		
		//�����ͺ��̽��� 1�� �ֱ�!!
		boardDAOMybatis.insert(board);
		
		return "redirect:/board/list.do";
	}
	
	
}








