package com.learner_academy.service.Impl;

import java.util.List;

import com.learner_academy.DAO.ClassesDAO;
import com.learner_academy.DAO.Impl.ClassesDAOImpl;
import com.learner_academy.exception.BusinessException;
import com.learner_academy.model.Classes;
import com.learner_academy.service.ClassesService;

public class ClassesServiceImpl implements ClassesService {

	private ClassesDAO dao = new ClassesDAOImpl();

	@Override
	public Classes createClasses(Classes classes) {

		return dao.createClasses(classes);

	}

	@Override
	public Classes getClassesById(int classId) throws BusinessException {

		if (classId <= 0) {
			throw new BusinessException("The classId cannot be Zero or Negative. Please supply the right classId.");
		}
		Classes classes = dao.getClassesById(classId);
		if (classes == null) {
			throw new BusinessException(
					"The class with classId '" + classId + "' does not exist. Please supply the right classId");
		}
		return classes;
	}

	@Override
	public List<Classes> getAllClasses() {

		return dao.getAllClasses();
	}

	@Override
	public Classes updateClasses(Classes classes) {

		return dao.updateClasses(classes);

	}

	@Override
	public void removeClasses(int classId) {

		dao.removeClasses(classId);

	}
}
