package com.keduit.sample;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Component
@ToString
@Getter
//위 세개를 다 합쳐서 @Data로 줄 수도 있음

//@AllArgsConstructor
@RequiredArgsConstructor //@AllArgsConstructor 대신 쓸수 있음. 단, @RequiredArgsConstructor 는 NonNull or final을 주어야만 사용 가능.

public class Hotel {
	
//	@NonNull 붙이거나, 아래처럼 final 붙이는건 같은 뜻임 
	private final Chef chef;
	private Restaurant restaurant;
	
} 
