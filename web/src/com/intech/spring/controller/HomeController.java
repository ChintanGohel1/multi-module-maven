package com.intech.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.intech.spring.service.student.StudentService;

@Controller
public class HomeController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getPage() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("students", studentService.getAllStudent());
		return mv;
	}
	/*
	 * @RequestMapping("/addStudent") public String addStudent() { return
	 * "index"; }
	 * 
	 * @RequestMapping("/updateStudent/{id}") public String
	 * updateStudent(@PathVariable int id) {
	 * 
	 * studentService.updateStudent(id); return "index"; }
	 * 
	 * @RequestMapping("/deleteStudent/{id}") public String
	 * deleteStudent(@PathVariable int id) { studentService.deleteStudent(id);
	 * return "index"; }
	 * 
	 * @RequestMapping("/getStudents") public String getAllStudents(Model m) {
	 * m.addAttribute("stud", studentService.getAllStudent()); // ModelAndView
	 * mv = new ModelAndView("index"); //
	 * mv.addObject(studentService.getAllStudent()); return "index"; }
	 */
}
