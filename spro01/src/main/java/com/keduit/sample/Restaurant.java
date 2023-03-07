package com.keduit.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import lombok.Data;
import lombok.Setter;

@Component
@Data
public class Restaurant {

      @Setter(onMethod_ = @Autowired)
      private Chef chef;

      // 		위 세터의 의미는 아래와 같음      
//      public void setChef(Chef cher) {
//    	  this.chef = chef;
//      }
      
}