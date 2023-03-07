package com.keduit.service;

import java.util.List;

import com.keduit.domain.TodoVO;

public interface TodoService {
	
	public List<TodoVO> getList(); // GetList(목록)

	public Long register(TodoVO todo); // Create(Insert)
	
	public TodoVO get(Long no); // Read(상세조회)
	
	public boolean modify(TodoVO todo); // Update(수정)
	
	public boolean remove(Long no); // Delete(삭제)
	
	
}
