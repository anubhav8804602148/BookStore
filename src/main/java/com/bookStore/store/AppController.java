package com.bookStore.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

	@Autowired
	private UserRepository repo;

	@GetMapping("index")
	public String viewHomePage() {
		System.out.println();
		return "index";
	}
	@GetMapping("")
	public String viewIndexPage() {
		System.out.println();
		return "index";
	}
	@GetMapping("login")
	public String viewLoginPage() {
		
		return "login";
	}
	@GetMapping("register")
	public String viewRegisterPage(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}
	@PostMapping("/process_register")
	public String processRegistration(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		repo.save(user);
		return "registerSuccess";
	}

	@GetMapping("/list_users")
	public String viewUserList(Model model) {
		List<User> listUsers = repo.findAll();
		model.addAttribute("listUsers", listUsers);
		return "users";
	}
	
	@GetMapping("/error")
	public String viewErrorPage() {
		return "errro";
	}
}
