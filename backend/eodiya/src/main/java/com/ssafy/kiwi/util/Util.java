package com.ssafy.kiwi.util;

import java.security.MessageDigest;
import java.security.SecureRandom;

import org.springframework.stereotype.Component;

@Component
public class Util {

	// 비밀번호 해싱 
	public String Hashing(String password,String salt) throws Exception {
		MessageDigest md = MessageDigest.getInstance("SHA-256");	// SHA-256 해시함수를 사용 

		// key-stretching
		for(int i = 0; i < 10000; i++) {
			String newPassword = password + salt;	// 패스워드와 Salt 를 합쳐 새로운 문자열 생성 
			md.update(newPassword.getBytes());		// temp 의 문자열을 해싱하여 md 에 저장해둔다 
			byte[] temp = md.digest();				// md 객체의 다이제스트를 얻어 password 를 갱신한다 
			password = Byte_to_String(temp);									
		}
		return password;
	}
	
	// 바이트 값을 16진수로 변경해준다 
	public String Byte_to_String(byte[] temp) {
		StringBuilder sb = new StringBuilder();
		for(byte a : temp) {
			sb.append(String.format("%02x", a));
		}
		return sb.toString();
	}
	
	//임의의 salt 값 생성
	public String getSalt() {
		SecureRandom rnd = new SecureRandom();
		byte[] temp = new byte[16];
		rnd.nextBytes(temp);
		return Byte_to_String(temp);
	}

}
