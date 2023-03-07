package com.keduit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.keduit.domain.TodoVO;
import com.keduit.service.TodoService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/todo/*")
@RequiredArgsConstructor
public class TodoController {

	private final TodoService service;
	
	@GetMapping("/list")
	public void list(Model model) {
		
		log.info("---------- TodoController list ----------");
		model.addAttribute("list", service.getList());
	}
	
	@PostMapping("/register")
	public String register(TodoVO todo, RedirectAttributes rttr) {
		
		log.info("---------- TodoController register ----------" + todo);
		Long no = service.register(todo);
		log.info("---------- no ----------" + no);
		
		rttr.addFlashAttribute("result", no); //addFlashAttribute : 1회용(=도배방지용)
		
		return "redirect:/todo/list";
	}
	
	@GetMapping({"/get"})
	public void get(@RequestParam("no") Long no, Model model) {
		
		log.info("---------- TodoController get ----------");
		model.addAttribute("todo",service.get(no));
	}
	
	@GetMapping({"/modify"})
	public void modify(@RequestParam("no") Long no, Model model) {
		
		log.info("/modify");
		model.addAttribute("todo",service.get(no));
	}	
	
	
	
	
//	@PostMapping("/modify")
//	public String modify(TodoVO todo, RedirectAttributes rttr) {
//		
//		log.info("---------- TodoController modify ----------" + todo);
//		
//		if(service.modify(todo)) {
//			rttr.addFlashAttribute("result", "success");
//		}
//		
////		rttr.addAllAttributes(")
//		
//		return "redirect:/todo/modify";
//	}
	
	
}
