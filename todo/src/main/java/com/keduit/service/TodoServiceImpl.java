package com.keduit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.keduit.domain.TodoVO;
import com.keduit.mapper.TodoMapper;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@ToString
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{

	private final TodoMapper mapper;
	
	@Override
	public Long register(TodoVO todo) { // Create(Insert)
		log.info("-------------------- register --------------------" + todo);
		
		int result = mapper.insertSelectKey(todo);
		log.info("-------------------- Todo 등록 상태 : " + result);
		
		return (todo.getNo());
	}

	@Override 
	public TodoVO get(Long no) { // Read(상세조회)
		log.info("-------------------- get --------------------" + no);
		
		return mapper.read(no);
	}

	@Override
	public boolean modify(TodoVO todo) { // Update(수정)
		log.info("-------------------- modify --------------------" + todo);
		
		return mapper.update(todo) == 1;
	}

	@Override
	public boolean remove(Long no) { // Delete(삭제)
		log.info("-------------------- remove --------------------" + no);
		
		return mapper.delete(no) == 1;
	}

	@Override
	public List<TodoVO> getList() { // GetList(목록)
		log.info("-------------------- getList --------------------");
		
		return mapper.getList();
	}
}
