package com.jmc.api.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.codec.digest.DigestUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

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

	/**
	 * 获取实体类字段的属性和值
	 * 
	 * @param model
	 * @return
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
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

	/**
	 * SHA1加密
	 * 
	 * @param str
	 * @return
	 */
	public static String getSha1(String str) {

		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
			mdTemp.update(str.getBytes(StandardCharsets.UTF_8));
			byte[] md = mdTemp.digest();
			int j = md.length;
			char buf[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
				buf[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(buf);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 获取bdf2框架的加密密码
	 * 
	 * @param psd  明文密码
	 * @param salt 随机数
	 * @return
	 */
	public static String bdf2Encrypt(String psd, String salt) {
		return DigestUtils.sha1Hex(psd + "{" + salt + "}");
	}

	/**
	 * 获取bdf2框架的加密密码
	 *
	 * @param psd 明文密码
	 * @return
	 */
	public static String bdf2Encrypt(String psd) {
		String salt = String.valueOf(getRandomNum());
		return DigestUtils.sha1Hex(psd + "{" + salt + "}");
	}

	/**
	 * 获取从1-1000的随机整型数
	 * 
	 * @return
	 */
	public static int getRandomNum() {
		return (int) (1 + Math.random() * (1000 - 1 + 1));
	}

}
