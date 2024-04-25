package com.ssafy.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.model.Member;
import com.ssafy.model.Product;
import com.ssafy.service.MainServiceImpl;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

	private final MainServiceImpl mainService;
	
	public MainController(MainServiceImpl mainService) {
		this.mainService = mainService;
	}
	
	@GetMapping(value = {"/","/index"})
	public String index() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam Map<String,String> map,HttpSession session, RedirectAttributes attributes ) {
		try {
			Member member = mainService.loginMember(map);
			
			
			if (member == null) {
				attributes.addFlashAttribute("msg", "아이디 또는 비밀번호가 틀립니다.");
				return "redirect:/login";	
			}
			
			session.setAttribute("user", member);
			return "index";
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "index";
	}
		
	@GetMapping("/logout")
	public String logout(HttpSession session ) {
		session.invalidate();
		
		return "index";
	}
	
	@GetMapping("/list")
	public String listProduct(Model model , HttpSession session) {
		if(!isUserLoggedIn(session))
			return "redirect:/login";
		
		try {
			List<Product> list = mainService.listProduct();
			 
			model.addAttribute("products", list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "list";
	}
	
	@GetMapping("/regist")
	public String registProduct() {
		return "regist";
	}
	
	@PostMapping("/regist") 
	public String registProduct(@RequestParam Map<String, String> map, Model model , HttpSession session) {
		if(!isUserLoggedIn(session))
			return "redirect:/login";
		
		try {
			mainService.registProduct(map);
			model.addAttribute("products", mainService.listProduct());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "list";
	}
	
	@GetMapping("/deleteProduct")
	public String deleteProduct(@RequestParam("code") String code , HttpSession session) {
		if(!isUserLoggedIn(session))
			return "redirect:/login";
		
		try {
			if(!isAuthorizationLoggedIn(session, code))
				return "redirect:/list";
			
			mainService.deletePorcut(code);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect: list";
	}
	
	@GetMapping("/updateProduct")
	public String updateProduct(@RequestParam("code") String code, Model model, HttpSession session) {
		if(!isUserLoggedIn(session))
			return "redirect:/login";
		
		try {
			if(!isAuthorizationLoggedIn(session, code))
				return "redirect:/list";
			
			Product product = mainService.select(code);
			model.addAttribute("product", product);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "update";
	}
	
	@PostMapping("/updateProduct")
	public String updateProduct(@RequestParam Map<String, String> map, Model model, HttpSession session) {
		if(!isUserLoggedIn(session))
			return "redirect:/login";
		
		try {   
			if(!isAuthorizationLoggedIn(session, map.get("code")))
				return "redirect:/list";
			
			mainService.updateProduct(map);
			model.addAttribute("products", mainService.listProduct());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "redirect: list";
	}
	
	@GetMapping("/detailProduct")
	public String detailProduct(@RequestParam("code") String code, Model model, HttpSession session) {
		if(!isUserLoggedIn(session))
			return "redirect:/login";
		
		try {
			if(!isAuthorizationLoggedIn(session, code))
				return "redirect:/list";
			
			Product product = mainService.select(code);
			model.addAttribute("product", product);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "detail";
	}
	
	@GetMapping("/signup")
	public String registMember() {
		return "signup";
	}
	
	@PostMapping("/signup") 
	public String registMember(@RequestParam Map<String, String> map, RedirectAttributes attributes) {
		try {
			int count = mainService.signupMember(map);
			
			if (count >= 1) {
				 attributes.addFlashAttribute("msg", "회원가입이 성공적으로 이루어졌습니다. 로그인해주세요.");
				 return "redirect:/login";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 return "signup";
	}
	
	public  boolean isUserLoggedIn(HttpSession session) {
        return session != null && session.getAttribute("user") != null;
    }
	
	public  boolean isAuthorizationLoggedIn(HttpSession session, String code) throws SQLException {
		String id = mainService.select(code).getId();
		Member member = (Member) session.getAttribute("user");
		
        return session != null && (session.getAttribute("user") != null && member.getId().equals("admin") ||
        		id.equals(member.getId()));
    }


	@GetMapping("/error/404")
	public String error() {
		return "/error/404";
	}
}
