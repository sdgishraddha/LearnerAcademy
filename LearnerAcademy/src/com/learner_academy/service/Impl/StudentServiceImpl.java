package com.learner_academy.service.Impl;

import java.util.List;

import com.learner_academy.DAO.StudentDAO;
import com.learner_academy.DAO.Impl.StudentDAOImpl;
import com.learner_academy.exception.BusinessException;
import com.learner_academy.model.Student;
import com.learner_academy.service.StudentService;

public class StudentServiceImpl implements StudentService {

	private StudentDAO dao = new StudentDAOImpl();

	@Override
	public Student createStudent(Student student) {

		return dao.createStudent(student);
	}

	@Override
	public Student getStudentById(int studentId) throws BusinessException {

		if (studentId <= 0) {
			throw new BusinessException("The studentId cannot be Zero or Negative. Please supply the right studentId.");
		}
		Student student = dao.getStudentById(studentId);
		if (student == null) {
			throw new BusinessException(
					"The student with studentId '" + studentId + "' does not exist. Please supply the right studentId");
		}
		return student;

	}

	@Override
	public List<Student> getAllStudents() {

		return dao.getAllStudents();
	}

	@Override
	public Student updateStudent(Student student) {

		return dao.updateStudent(student);
	}

	@Override
	public void removeStudent(int studentId) {

		dao.removeStudent(studentId);

	}
}
