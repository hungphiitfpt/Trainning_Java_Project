package com.poly.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.model.Customes;
import com.poly.repository.CustomerRepository;



@Controller
public class HomeController {

	@Autowired
	private CustomerRepository customerRepository;

	@GetMapping("/index")
	public String index(HttpServletRequest request, Model model,
			  
		      @RequestParam(name = "page", required = false, defaultValue = "0") int page,
		      @RequestParam(name = "name", required = false)  String name,  
		      @RequestParam(name = "size", required = false, defaultValue = "5") int size,
		      @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort) {

//		if (request.getParameter("page") != null && !request.getParameter("page").isEmpty()) {
//			page = Integer.parseInt(request.getParameter("page")) - 1;
//		}
//
//		if (request.getParameter("size") != null && !request.getParameter("size").isEmpty()) {
//			size = Integer.parseInt(request.getParameter("size"));
//		}
	
		model.addAttribute("customers", customerRepository.findAll(PageRequest.of(page, size)));
		return "customers";
	}
//	@GetMapping("search/panigated")
//	public String search(ModelMap model, 
//			@RequestParam(name = "name", required = false) String name,
//			@RequestParam(name = "description", required = false) String description,
//			@RequestParam("page") Optional<Integer> page,
//			@RequestParam("size") Optional<Integer> size) {
//		
//		int currentPage = page.orElse(1);
//		int pagesize = size.orElse(5);
// 
//		Pageable pageable = PageRequest.of(currentPage, pagesize);
//		
//		Page<Customes> resultpage = null;
//
//		Page<Customes> list = customerRepository.findAllbY(name, description, pageable);
//
//		model.addAttribute("customers", list);
//		return "customers";
//
//	}
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/customers")
	public String customersPage( Model model, HttpServletRequest request,
		      @RequestParam(name = "page", required = false, defaultValue = "0") int page,
		      @ModelAttribute("name")  String name,  
		      @ModelAttribute(name = "address")  String address, 
		      @RequestParam(name = "size", required = false, defaultValue = "5") int size,
		      @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort) {

//		if (request.getParameter("page") != null && !request.getParameter("page").isEmpty()) {
//			page = Integer.parseInt(request.getParameter("page")) - 1;
//		}
//
//		if (request.getParameter("size") != null && !request.getParameter("size").isEmpty()) {
//			size = Integer.parseInt(request.getParameter("size"));
//		}
		name = request.getParameter("name");
		model.addAttribute("customers", customerRepository.findAllbY(name,address,PageRequest.of(page, size)));
		return "customers";
	}

//	
//	@GetMapping("/customers")
//	public Page<Customes> customersPage( Model model,
//			  
//		      @RequestParam(name = "page", required = false, defaultValue = "0") int page,
//		      @RequestParam(name = "name", required = false)  String name,  
//		      @RequestParam(name = "address", required = false)  String address, 
//		      @RequestParam(name = "size", required = false, defaultValue = "5") int size,
//		      @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort) {
//
////		if (request.getParameter("page") != null && !request.getParameter("page").isEmpty()) {
////			page = Integer.parseInt(request.getParameter("page")) - 1;
////		}
////
////		if (request.getParameter("size") != null && !request.getParameter("size").isEmpty()) {
////			size = Integer.parseInt(request.getParameter("size"));
////		}
//	Page<Customes> list = customerRepository.findAllbY(name,address,PageRequest.of(page, size));
//		return list;
//	}

}
