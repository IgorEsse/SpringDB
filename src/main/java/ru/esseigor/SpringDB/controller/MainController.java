package ru.esseigor.SpringDB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.esseigor.SpringDB.dao.UserDAO;
import ru.esseigor.SpringDB.model.UserInfo;
import ru.esseigor.SpringDB.model.UserInfoForm;

@Controller
public class MainController {
	
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showMenu() {
		return "_menu";
	}
	
	@RequestMapping(value = "/AllUsers", method = RequestMethod.GET)
	public String showUsers(Model model) {
		List<UserInfo> list = userDAO.getUsers();
		model.addAttribute("UserInfos",list);
		return "UsersPage";
	}
	
	@RequestMapping(value = "/FindUsers", method = RequestMethod.GET)
	public String findUsers(Model model) {
		UserInfoForm userInfoForm = new UserInfoForm();
		model.addAttribute("userInfoForm",userInfoForm);
		return "FindUsersPage";
	}
	
	@RequestMapping(value = "/FindUsers", method = RequestMethod.POST)
	public String findUsers(Model model,UserInfo user) {
		System.out.println("Получен запрос с параметром: login = " + user.getLogin());
		List<UserInfo> list = userDAO.findUser(user.getLogin());
		model.addAttribute("UserInfos",list);
		return "UsersPage";
	}
}
