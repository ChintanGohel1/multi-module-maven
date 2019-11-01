package com.intech.spring.service.student;

import java.util.List;

import org.springframework.stereotype.Service;

import com.intech.rest.hibernate.HibernateUtil;
import com.intech.rest.model.Student;
import com.intech.spring.beanfactory.BeanFactory;
import com.intech.spring.service.student.dto.StudentDTO;

@Service
public class StudentService {

	public void addStudent(StudentDTO studentDTO) throws InstantiationException, IllegalAccessException {
		HibernateUtil.save(BeanFactory.build(Student.class, studentDTO));
	}

	public StudentDTO get(int id) throws InstantiationException, IllegalAccessException {
		return BeanFactory.build(StudentDTO.class, HibernateUtil.get(Student.class, id));

	}

	public void deleteStudent(int id) {
		Student student = (Student) HibernateUtil.get(Student.class, (Integer) id);
		HibernateUtil.delete(student);
	}

	public void updateStudent(StudentDTO studentDTO) {
		Student student = (Student) HibernateUtil.get(Student.class, studentDTO.getId());
		student.setMarks(studentDTO.getMarks());
		student.setMobile(studentDTO.getMobile());
		student.setName(studentDTO.getName());

		HibernateUtil.update(student);
	}

	public List<Student> getAllStudent() {
		return HibernateUtil.findAll(new Student());
	}

}
