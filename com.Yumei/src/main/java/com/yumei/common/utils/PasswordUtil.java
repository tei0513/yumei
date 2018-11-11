package com.yumei.common.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 密码工具类。
 * 
 * @author Administrator
 * @Date 2018年11月11日
 */
public final class PasswordUtil {
	
	/**
	 * 工具类隐藏构造函数
	 */
	private PasswordUtil() {
	}

	/**
	 * sha256用转换码<br>
	 * 值是{@value}
	 */
	private static final int SHA256_CODE = 0xFF;

	/**
	 * 密码加密,采用sha256。<br>
	 * [备考]sha256加密算法密码常长度统一为64位
	 * 
	 * @param password 原始密码
	 * @return 加密后的密码
	 */
	public static String encryptSha256(String password) {
		String encdeStr = "";
		try {
			// 设置加密算法
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			// 设置编码
			md.update(password.getBytes("UTF-8"));
			// 加密后的密码转换成String
			encdeStr = byte2Hex(md.digest());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		// 返回加密后最终结果
		return encdeStr;
	}

	/**
	 * 将byte转换成String并加密
	 * 
	 * @param bytes 加密内容体
	 * @return 加密后的内容
	 */
	private static String byte2Hex(byte[] bytes) {
		StringBuffer stringBuffer = new StringBuffer();
		String temp = null;
		for (int i = 0; i < bytes.length; i++) {
			temp = Integer.toHexString(bytes[i] & SHA256_CODE);
			if (temp.length() == 1) {
				stringBuffer.append("0");
			}
			stringBuffer.append(temp);
		}
		return stringBuffer.toString();
	}
}
