package com.keduit.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.keduit.domain.TodoVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TodoMapperTests {
	
	SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
	
	@Setter(onMethod_ = @Autowired)
	private TodoMapper mapper;
	
	@Test
	public void testGetTime() {
		log.info(mapper.getClass().getName());
		log.info(mapper.getTime());
	}	
	
// GetList(목록)
	@Test
	public void testGetList() { 
		mapper.getList().forEach(todo -> log.info(todo));
	}
	
// Create(Insert)
	@Test
	public void testInsert() throws ParseException { // PK값 알 필요 없을 때
		TodoVO todo = new TodoVO();
		todo.setTodoDate(date.parse("2023-01-20"));
		todo.setContent("영화 예매");
		
		mapper.insert(todo);
		
		log.info("==================== testInsert() ====================" + todo);
	}
	@Test
	public void testInsertSelectKey() throws ParseException { // PK값 알아야할 때
		TodoVO todo = new TodoVO();
		todo.setTodoDate(date.parse("2023-01-31"));
		todo.setContent("ERD 완성!");
		
		mapper.insertSelectKey(todo);
		
		log.info("==================== testInsertSelectKey() ====================" + todo);
	}
	
// Read(상세조회)
	@Test
	public void testRead() {
		TodoVO todo = new TodoVO();
		todo = mapper.read(4L); // 게시물 번호로 조회
		
		log.info("==================== testRead() ====================" + todo );
	}
	
// Delete(삭제)	
	@Test
	public void testDelete() {
		int result = mapper.delete(9L);
		log.info("==================== delete() ====================");
		log.info("delete한 갯수 => " + result);
	}

// Update(수정)
	@Test
	public void testUpdate() throws ParseException {
		TodoVO todo = new TodoVO();
		todo.setTodoDate(date.parse("2023-01-24"));
		todo.setContent("여의도 한강공원 치맥");
		todo.setNo(63L);
		
		int result = mapper.update(todo);
		log.info("==================== testUpdate() ====================");
		log.info("update한 갯수 => " + result);
		
	}
	
}
