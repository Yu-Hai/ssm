package com.office.common.config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.springframework.util.ResourceUtils;

/**
 * 
 * 全局配置类
 * 
 */
public class GlobalValueConfig {
	private static Properties configProp = new Properties();
	private static volatile String accessToke;

	public static void init() {
		try {
			File file = ResourceUtils.getFile("classpath:config.properties");
			configProp.load(new FileInputStream(file));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getConfig(String key) {
		return (String) configProp.get(key);
	}
	
	/*public static String getImgPath() {
		return (String) configProp.get("img_path")+"/";
	}*/

	public static Object getMsgByCode(String responseCode, String responseMsg) {
		return responseMsg;
	}

}
