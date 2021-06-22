package com.redhat.fuse.boosters.configmap;

import java.io.File;

import org.springframework.stereotype.Component;

@Component
public class FileProcessor {
	
	
	public void process(File file) {
		System.out.println(file.getName());
	}

}
