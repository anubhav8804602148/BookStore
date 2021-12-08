package com.bookStore.store;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

	Authentication auth;
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private BookRepository bookRepo;

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

	@GetMapping("/notAuthorized")
	public String showNotAuthorizedPage() {
		return "notAuthorized";
	}
	
	@GetMapping("/list_users")
	public String viewUserList(Model model) {
		auth = SecurityContextHolder.getContext().getAuthentication();
		if(!repo.findByEmail(auth.getName()).getRole().equals("ADMIN")){
			return "notAuthorized";
		}
		List<User> listUsers = repo.findAll();
		model.addAttribute("listUsers", listUsers);
		return "users";
	}

	@GetMapping("/books")
	public String vieBookList(Model model) {
		List<Book> listBooks = bookRepo.findAll();
		model.addAttribute("listBooks", listBooks);
		return "books";
	}
	
	@GetMapping("/error")
	public String viewErrorPage() {
		return "error";
	}
	
	@GetMapping("/register_books")
	public String viewRegisterBookPage(Model model) {
		model.addAttribute("book", new Book());
		return "registerBook";
	}
	@PostMapping("/process_register_book")
	public String processBookRegistration(Book book) {
		bookRepo.save(book);
		return "bookRegisterSuccess";
	}
	
	@GetMapping("/bulk_upload")
	public String viewBulkUploadPage(Model model) {
		model.addAttribute("uploadFile", new UploadFile());
		return "bulkUpload";
	}
	
	@PostMapping("/process_bulk_upload")
	public String processBulkFile(UploadFile uploadFile) {
		System.out.println(uploadFile.file.getTotalSpace());
		return "bookRegisterSuccess";
	}
	
	@GetMapping("/payment")
	public String makePayment() {
		return "payment";
	}

}
