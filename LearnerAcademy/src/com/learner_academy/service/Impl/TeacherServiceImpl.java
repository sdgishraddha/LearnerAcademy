package com.learner_academy.service.Impl;

import java.util.List;

import com.learner_academy.DAO.TeacherDAO;
import com.learner_academy.DAO.Impl.TeacherDAOImpl;
import com.learner_academy.exception.BusinessException;
import com.learner_academy.model.Teacher;
import com.learner_academy.service.TeacherService;

public class TeacherServiceImpl implements TeacherService {

	private TeacherDAO dao = new TeacherDAOImpl();

	@Override
	public Teacher createTeacher(Teacher teacher) {

		return dao.createTeacher(teacher);
	}

	@Override
	public Teacher getTeacherById(int teacherId) throws BusinessException {
		if (teacherId <= 0) {
			throw new BusinessException("The teacherId cannot be Zero or Negative. Please supply the right teacherId.");
		}
		Teacher teacher = dao.getTeacherById(teacherId);
		if (teacher == null) {
			throw new BusinessException(
					"The teacher with teacherId '" + teacherId + "' does not exist. Please supply the right teacherId");
		}
		return teacher;
	}

	@Override
	public List<Teacher> getAllTeachers() {

		return dao.getAllTeachers();
	}

	@Override
	public Teacher updateTeacher(Teacher teacher) {

		return dao.updateTeacher(teacher);
	}

	@Override
	public void removeTeacher(int teacherId) {

		dao.removeTeacher(teacherId);

	}

}
