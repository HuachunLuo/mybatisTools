package com.systexgc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.systexgc.dao")
public class JavatoolsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavatoolsApplication.class, args);
	}

}

