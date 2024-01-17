package com.wisenut;

import java.io.File;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class InitializeSettings {

	@PostConstruct
	public void init() {

		final String os = System.getProperty("os.name");
		if (os.contains("Windows"))
			return;

		final String homePath = "~";

		File home = new File(homePath);
		if (!home.exists()) {
			boolean isDirCreated = home.mkdir();
			if (isDirCreated) {
				log.info(homePath + " 디렉토리가 생성되었습니다.");
			} else {
				log.info(homePath + " 디렉토리를 생성하지 못했습니다.");
			}
		}
	}
}
