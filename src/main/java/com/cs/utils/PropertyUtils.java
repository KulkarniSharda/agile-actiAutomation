package com.cs.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.cs.constants.Frameworkconstants;
import com.cs.enums.ConfigProperties;

public final class PropertyUtils {

	private static Properties prop = new Properties();
	private static final Map<String, String> CONFIGMAP = new HashMap<>();

	private PropertyUtils() {}

	static {
		try {
			FileInputStream fis = new FileInputStream(Frameworkconstants.getConfigmapfilepath());
			prop.load(fis);
			for (Map.Entry<Object, Object> entry : prop.entrySet()) {
				CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String get(ConfigProperties key) throws Exception {
		if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase())))
			throw new Exception("problem in reading property " + key + " please check config.properties file");
		return CONFIGMAP.get(key.name().toLowerCase());
	}
}
