package com.intech.spring.controller.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.intech.rest.model.Student;
import com.intech.spring.beanfactory.BeanFactory;
import com.intech.spring.controller.student.bean.AddStudentRequestBean;
import com.intech.spring.controller.student.bean.StudentBean;
import com.intech.spring.service.student.StudentService;
import com.intech.spring.service.student.dto.StudentDTO;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(path = "/addStudent", method = RequestMethod.GET)
	public ModelAndView addStud() {
		ModelAndView mv = new ModelAndView("addStudent");
		mv.addObject("command", new Student());
		return mv;
	}

	@RequestMapping(path = "/addStud", method = RequestMethod.POST)
	public ModelAndView addStudent(@ModelAttribute AddStudentRequestBean addStudentRequestBean)
			throws InstantiationException, IllegalAccessException {

		ModelAndView mv = new ModelAndView("redirect:/showStudent");
		studentService.addStudent(BeanFactory.build(StudentDTO.class, addStudentRequestBean));
		return mv;
	}

	@RequestMapping(path = "/showStudent", method = RequestMethod.GET)
	public ModelAndView getAllStudents() {
		ModelAndView mv = new ModelAndView("showStudent");
		mv.addObject("all", studentService.getAllStudent());
		return mv;
	}

	@RequestMapping("/deleteStudent/{id}")
	public ModelAndView deleteStudent(@PathVariable int id) {
		studentService.deleteStudent(id);
		ModelAndView mv = new ModelAndView("redirect:/showStudent");
		mv.addObject("all", studentService.getAllStudent());
		return mv;
	}

	@RequestMapping("/editStudent/{id}")
	public ModelAndView editStudent(@PathVariable int id) throws InstantiationException, IllegalAccessException {
		// studentService.editStudent(id);
		ModelAndView mv = new ModelAndView("editStudent");
		mv.addObject("command", BeanFactory.build(StudentBean.class, studentService.get(id)));
		return mv;
	}

	@RequestMapping(path = "/editAndSave", method = RequestMethod.POST)
	public ModelAndView editAndSaveStudent(@ModelAttribute StudentBean studentBean)
			throws InstantiationException, IllegalAccessException {

		studentService.updateStudent(BeanFactory.build(StudentDTO.class, studentBean));
		ModelAndView mv = new ModelAndView("redirect:/showStudent");
		mv.addObject("all", studentService.getAllStudent());
		return mv;
	}

}
