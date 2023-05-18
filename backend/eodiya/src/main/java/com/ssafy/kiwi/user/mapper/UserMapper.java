package com.ssafy.kiwi.user.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.kiwi.user.model.UserDto;

@Mapper
public interface UserMapper {

	UserDto login(String id, String pw) throws Exception;

	void saveRefreshToken(Map<String, String> map) throws Exception;

	Object getRefreshToken(String userid) throws Exception;

	void deleteRefreshToken(Map<String, String> map) throws Exception;

	String findSalt(String id) throws Exception;
}
