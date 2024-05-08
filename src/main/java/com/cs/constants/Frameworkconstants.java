package com.cs.constants;

import java.time.Duration;

public final class Frameworkconstants {

	private static final String RESOURCEPATH      = System.getProperty("user.dir")+ "/src/test/resources"; 
	private static final String CONFIGMAPFILEPATH = RESOURCEPATH + "/config/config.properties";
	private static final Duration EXPLICITWAIT = Duration.ofSeconds(5);
	
	public static Duration getExplicitwait() {
		return EXPLICITWAIT;
	}

	public static String getResourcepath() {
		return RESOURCEPATH;
	}

	public static String getConfigmapfilepath() {
		return CONFIGMAPFILEPATH;
	}




	private Frameworkconstants() {} 
	
}
