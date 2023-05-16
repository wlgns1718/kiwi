package com.ssafy.kiwi.user.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.kiwi.user.mapper.UserMapper;
import com.ssafy.kiwi.user.model.UserDto;
import com.ssafy.kiwi.util.Util;

@Service
public class UserServiceImpl implements UserService {

	private Util util;
	private UserMapper userMapper;

	@Autowired
	public UserServiceImpl(UserMapper userMapper, Util util) {
		super();
		this.userMapper = userMapper;
		this.util = util;
	}

	@Override
	public UserDto login(String id, String pw) throws Exception {
		String salt = (String) userMapper.findSalt(id);
		String npw = util.Hashing(pw, salt);
		return userMapper.login(id, npw);
	}

	@Override
	public int addUser(String name, String id, String pw, String email) throws Exception {
		String salt = util.getSalt();
		String npw = util.Hashing(pw, salt);
		return userMapper.addUser(name, id, npw, email, salt);

	}

	@Override
	public boolean checkUser(String id) throws Exception {
		return userMapper.checkUser(id);
	}

	@Override
	public int edit(String name, String id, String pw, String email) throws Exception {
		String salt = (String) userMapper.findSalt(id);
		String npw = util.Hashing(pw, salt);
		
		return userMapper.edit(name, id, npw, email);
		
	}

	@Override
	public int delete(String id) throws Exception {
		
		return userMapper.delete(id);
	}

	@Override
	public List<UserDto> listMember(Map<String, Object> map) throws Exception {
		return userMapper.listMember(map);
	}

	@Override
	public UserDto getMember(String userId) throws Exception {
		return userMapper.getMember(userId);
	}

	@Override
	public void updateMember(UserDto memberDto) throws Exception {
		userMapper.updateMember(memberDto);
	}

	@Override
	public void deleteMember(String userid) throws Exception {
		userMapper.deleteMember(userid);
	}

}
