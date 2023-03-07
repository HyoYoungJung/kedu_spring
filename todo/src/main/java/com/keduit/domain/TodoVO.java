package com.keduit.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TodoVO {
	
	private Long no;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date todoDate;
	private String content;
	private Date regDate;
	private Date updateDate;
	
}
