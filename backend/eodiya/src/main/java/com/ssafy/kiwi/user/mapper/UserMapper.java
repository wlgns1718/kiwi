package com.ssafy.kiwi.user.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.kiwi.user.model.UserDto;

@Mapper
public interface UserMapper {

	UserDto login(String id, String pw) throws Exception;

	int addUser(String name, String id, String pw, String email, String salt) throws Exception;

	int edit(String name, String id, String pw, String email) throws Exception;

	int delete(String id) throws Exception;

	boolean checkUser(String id) throws Exception;

	String findSalt(String id) throws Exception;

	List<UserDto> listMember(Map<String, Object> map) throws Exception;

	UserDto getMember(String userId) throws Exception;

	void updateMember(UserDto memberDto) throws Exception;

	void deleteMember(String userId) throws Exception;
}
