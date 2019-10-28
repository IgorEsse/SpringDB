package ru.esseigor.SpringDB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.esseigor.SpringDB.dao.UserDAO;
import ru.esseigor.SpringDB.model.UserInfo;

@Controller
public class MainController {
	
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showUsers(Model model) {
		List<UserInfo> list = userDAO.getUsers();
		model.addAttribute("UserInfos",list);
		return "UsersPage";
	}
}
