package com.keduit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.keduit.domain.TodoVO;

public interface TodoMapper {
	
	@Select("select sysdate from dual")
	public String getTime();
	
	// GetList(목록)
//	@Select("select * from todoList order by todoDate ASC")  // Mapper.xml에 GetList 구문 추가한 이후엔 막아줘야 오류 안남
	public List<TodoVO> getList();
	
	// Create(Insert)
	public void insert(TodoVO todo); //insert문 실행 및 PK값 알 필요 없을 때
	public int insertSelectKey(TodoVO todo); //insert문 실행 및 생성된 PK값 알아야할 때 <selectkey>사용
	
	// Read(상세조회)
	public TodoVO read(Long no);
	
	// Delete(삭제)
	public int delete(Long no);
	
	// Update(수정)
	public int update(TodoVO todo);
	
	
}
