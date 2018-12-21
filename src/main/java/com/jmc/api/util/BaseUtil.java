package com.jmc.api.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @Description: 基础工具类
 * @Author: mason_ge
 * @Date: 10:42 2018/12/18
 */
public class BaseUtil {
	/**
	 * OBJ转BigDecimal
	 *
	 * @param value
	 * @return
	 */
	public static BigDecimal getBigDecimal(Object value) {
		BigDecimal ret = null;
		if (value != null) {
			if (value instanceof BigDecimal) {
				ret = (BigDecimal) value;
			} else if (value instanceof String) {
				ret = new BigDecimal((String) value);
			} else if (value instanceof BigInteger) {
				ret = new BigDecimal((BigInteger) value);
			} else if (value instanceof Number) {
				ret = new BigDecimal(((Number) value).doubleValue());
			} else {
				throw new ClassCastException("Not possible to coerce [" + value + "] from class " + value.getClass()
						+ " into a BigDecimal.");
			}
		}
		return ret;
	}

	/**
	 * 将null或null字符串转化为空字符串,并trim
	 *
	 * @param str
	 * @return
	 */
	private static String convertNull2String(String str) {
		String res;
		if (str == null || "null".equals(str.trim())) {
			res = "";
		} else {
			res = str.trim();
		}
		return res;
	}

	/**
	 * 对象类型转换为字符串
	 *
	 * @param obj 参数
	 * @return String 字符串
	 */
	public static String object2String(Object obj) {
		return convertNull2String(String.valueOf(obj));
	}

	/**
	 * 对象转int
	 * 
	 * @param obj
	 * @return
	 */
	public static int obj2int(Object obj) {
		if (obj == null) {
			return 0;
		}
		if (obj instanceof String && "".equals(obj.toString())) {
			return 0;
		}
		return Integer.valueOf(obj.toString());
	}

	/**
	 * 转换字段的setter方法名，如pkId -> setPkId， pk_id -> setPkId
	 *
	 * @param fieldName 字段名
	 * @return
	 */
	public static String captureSetterFieldName(String fieldName) {
		String fragment, lowerFieldName;
		StringBuffer stringBuffer;
		StringTokenizer stringTokenizer;
		char[] chars;
		boolean init = true;

		lowerFieldName = fieldName.toLowerCase();
		stringTokenizer = new StringTokenizer(lowerFieldName, "_");

		stringBuffer = new StringBuffer("set");

		while (stringTokenizer.hasMoreTokens()) {
			fragment = stringTokenizer.nextToken();

			chars = fragment.toCharArray();
			if (init) {
				if (chars.length > 1) {
					chars[0] = Character.toUpperCase(chars[0]);
					// fragment = new String(chars);
				}
				init = false;
			} else {
				chars[0] = Character.toUpperCase(chars[0]);
				// fragment = new String(chars);
			}
			stringBuffer.append(chars);
		}

		return stringBuffer.toString();
	}

	/**
	 * 转换字段名，如pkId -> pkId， pk_id -> pkId
	 *
	 * @param fieldName 字段名
	 * @return
	 */
	public static String captureFieldName(String fieldName) {
		String fragment, lowerFieldName;
		StringBuffer stringBuffer;
		StringTokenizer stringTokenizer;
		char[] chars;
		boolean init = false;

		lowerFieldName = fieldName.toLowerCase();
		stringTokenizer = new StringTokenizer(lowerFieldName, "_");

		stringBuffer = new StringBuffer();

		while (stringTokenizer.hasMoreTokens()) {
			fragment = stringTokenizer.nextToken();

			if (init) {
				chars = fragment.toCharArray();
				chars[0] = Character.toUpperCase(chars[0]);
				// fragment = new String(chars);
				stringBuffer.append(chars);
			} else {
				stringBuffer.append(fragment);
				init = true;
			}
		}

		return stringBuffer.toString();
	}

	/**
	 * Base64编码
	 * 
	 * @param str
	 * @return
	 */
	public static String Base64Encode(String str) {
		BASE64Encoder encoder = new BASE64Encoder();
		try {
			return encoder.encodeBuffer(str.getBytes(StandardCharsets.UTF_8));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Base64解码
	 *
	 * @param str
	 * @return
	 */
	public static String Base64Decode(String str) {
		BASE64Decoder dec = new BASE64Decoder();
		try {
			byte[] b = dec.decodeBuffer(str);
			return new String(b, StandardCharsets.UTF_8);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Map<String, Object> getClzFieldProperties(Object model)
			throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String name, type;
		Method m;
		Map<String, Object> map = new HashMap<>(0);
		// 获取实体类的所有属性，返回Field数组
		Field[] field = model.getClass().getDeclaredFields();
		// 遍历所有属性
		for (int j = 0; j < field.length; j++) {
			// 获取属性的名字
			name = field[j].getName();
			// 将属性的首字符大写，方便构造get，set方法
			name = name.substring(0, 1).toUpperCase() + name.substring(1);
			m = model.getClass().getMethod("get" + name);
			map.put(field[j].getName(), m.invoke(model));
			// 获取属性的类型
			// type = field[j].getGenericType().toString();
		}
		return map;
	}
}
