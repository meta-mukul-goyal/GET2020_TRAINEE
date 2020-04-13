package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.StudentDetail;
import com.example.demo.service.StudentService;

@Controller
public class HomeController {
	@Autowired
	private StudentService studentServiceObj;
	
	@Value("${home.message}")
	private String message;
	
	@GetMapping("/")
	public ModelAndView home() {
		return new ModelAndView("homepage", "message", message);
	}
	
	@GetMapping("/addStudent")
	public String addStudent(Model model) {
		model.addAttribute("student", new StudentDetail());
		return "addStudent";
	}
	
	@PostMapping("/studentRegister")
	public ModelAndView showStudent(@Valid @ModelAttribute("student") StudentDetail sdObj, Errors errors) {
		if (errors.hasErrors()) {
			return new ModelAndView("addStudent");
		}
		System.out.println(sdObj.toString());
		studentServiceObj.addStudent(sdObj);
		return new ModelAndView("homepage","message", message); 
	}
	
	@RequestMapping("/showStudent")
	public ModelAndView showStudent() {
		return new ModelAndView("showStudent","studentList",studentServiceObj.getAllStudent());
	}
}
