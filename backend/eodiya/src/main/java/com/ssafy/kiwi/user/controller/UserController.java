package com.ssafy.kiwi.user.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.kiwi.tour.controller.TourController;
import com.ssafy.kiwi.user.model.UserDto;
import com.ssafy.kiwi.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	private final Logger logger = LoggerFactory.getLogger(UserController.class);

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping("/login")
	public String login(Model model, @RequestParam("id") String id, @RequestParam("password") String pw,
			RedirectAttributes redi, HttpSession session) throws Exception {

		logger.debug("LOGIN CALL");

		UserDto userDto = userService.login(id, pw);

		if (userDto != null) {
			session.setAttribute("msg", "로그인에 성공했습니다!");
			// 관리자일 경우 세션 추가
			if (userDto.getId().equals("ssafy")) {
				session.setAttribute("manager", userDto.getId());
			}
			session.setAttribute("id", userDto.getId());
			session.setAttribute("name", userDto.getNickname());
			session.setAttribute("email", userDto.getEmail());
			return "redirect:/";
		} else {
			session.setAttribute("msg", "비밀번호를 확인해 주세요!!");
			return "redirect:/";
		}

	}

	@PostMapping("/register")
	public String register(HttpSession session, String id, String password, String name, String email, String emailList)
			throws Exception {
		logger.debug("register Calling...");
		userService.addUser(name, id, password, email+"@"+emailList);
		session.setAttribute("msg", "회원가입 완료!");
		return "redirect:/";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	@GetMapping("/delete")
	public String delete(HttpSession session) throws Exception {
		String id = (String) session.getAttribute("id");
		session.invalidate();
		userService.delete(id);
		return "redirect:/";
	}
	@PostMapping("/modify")
	public String modify( String name, String password,HttpSession session) throws Exception {
		String id = (String) session.getAttribute("id");
		String email = (String)session.getAttribute("email");
		userService.edit(name, id, password, email);
		session.invalidate();
		
		return "redirect:/";
	}
}
