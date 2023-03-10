package com.keduit.mapper;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.keduit.domain.Criteria;
import com.keduit.domain.ReplyVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {
	
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;
	
	private Long[] bnoArr = {557101L, 557081L, 557078L, 557077L, 557076L};
	
	@Test
	public void testMapper() {
		log.info(mapper);
	}
	
	
	@Test
	public void testCreate() {
		IntStream.rangeClosed(1, 10).forEach( i-> {
			
			ReplyVO vo = new ReplyVO();
			
			vo.setBno(bnoArr[i%5]);
			vo.setReply("댓글 테스트" + i);
			vo.setReplyer("replyer"+i);
			
			mapper.insert(vo);
		});
	}
	
	@Test
	public void testRead() {
		Long targetRno = 10L;
		
		ReplyVO vo = mapper.read(targetRno);
		log.info(vo);
		
	}
	
	@Test
	public void testDelete() {
		int result = mapper.delete(2L);
		log.info("---------------------delete => " + result);
	}
	
	@Test
	public void testUpdate() {
		
		ReplyVO vo = mapper.read(10L);
		
		vo.setReply("댓글 수정 테스트 입니다");
		
		int result = mapper.update(vo);
		log.info("--------------------update count => " + result);
	}
	
	@Test
	public void testList() {
		Criteria cri = new Criteria();
		List<ReplyVO> replies = mapper.getListWithPaging(cri, bnoArr[2]);
		log.info("---------------------testList----" + replies);
		log.info(cri.toString());
	}
	
	@Test
	public void testList2() {
		Criteria cri = new Criteria(2,10);
		List<ReplyVO> replies = mapper.getListWithPaging(cri, 557101L);
		replies.forEach(reply -> log.info(reply));
	}
	
	
}
