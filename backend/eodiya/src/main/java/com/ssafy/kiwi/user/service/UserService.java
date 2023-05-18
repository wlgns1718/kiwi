package com.ssafy.kiwi.user.service;

import com.ssafy.kiwi.user.model.UserDto;

public interface UserService {

	UserDto login(String id, String pw) throws Exception;

	UserDto userInfo(String id) throws Exception;

	void saveRefreshToken(String userid, String refreshToken) throws Exception;

	Object getRefreshToken(String userid) throws Exception;

	void deleRefreshToken(String userid) throws Exception;

}
