package com.demo.spring.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.spring.Performer;
import com.demo.spring.aspect.Audience;

@Service
public class Singer implements Performer {

	//@Autowired
	//private Audience audience;

	@Override
	public void perform() {
		//audience.takeSeat();
		//audience.switchOffMobile();
		System.out.println("Singer is now singing the song...");
		//audience.applaud();

	}

}
