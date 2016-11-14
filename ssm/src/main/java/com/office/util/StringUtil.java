package com.office.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

	/**
	 * 判断是否是字母
	 * @param s
	 * @return
	 */
	public static boolean isLetter(String s) {
		boolean result = false;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int j = (int) c;
			System.out.println(c+"------"+j);
			if ((j >= 65 && j <= 90)||(j >= 97 && j <= 122)) {
				result = true;
			} else {
				return false;
			}
		}
		return result;
	}
	
	/**
	 * 从字符串中提取连续的数字
	 * @param str
	 * @return
	 */
	public static List<Integer> getNumFromStr(String str){
		List<Integer> list=new ArrayList<Integer>();
		Pattern p = Pattern.compile("\\d{1,}");//这个1是指连续数字的最少个数
		Matcher m = p.matcher(str);
		while (m.find()) {
			list.add(Integer.parseInt(m.group()));
		}
		return list;
	}
	
	
	public static void main(String args[]) throws Exception {
		getNumFromStr("((2*(19-13*(1-2)/39)/6-4)+5)/5+((2+3)*2-5)");
    }
}
