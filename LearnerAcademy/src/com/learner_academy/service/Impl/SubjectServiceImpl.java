package com.learner_academy.service.Impl;

import java.util.List;

import com.learner_academy.DAO.SubjectDAO;
import com.learner_academy.DAO.Impl.SubjectDAOImpl;
import com.learner_academy.exception.BusinessException;
import com.learner_academy.model.Subject;
import com.learner_academy.service.SubjectService;

public class SubjectServiceImpl implements SubjectService {

	private SubjectDAO dao = new SubjectDAOImpl();

	@Override
	public Subject createSubject(Subject subject) {

		return dao.createSubject(subject);
	}

	@Override
	public Subject getSubjectById(int subjectId) throws BusinessException {
		if (subjectId <= 0) {
			throw new BusinessException("The subejctId cannot be Zero or Negative. Please supply the right subjectId.");
		}
		Subject subject = dao.getSubjectById(subjectId);
		if (subject == null) {
			throw new BusinessException(
					"The subject with subjectId '" + subjectId + "' does not exist. Please supply the right subjectId");
		}
		return subject;
	}

	@Override
	public List<Subject> getAllSubject() {

		return dao.getAllSubject();
	}

	@Override
	public Subject updateSubject(Subject subject) {

		return dao.updateSubject(subject);
	}

	@Override
	public void removeSubject(int subjectId) {

		dao.removeSubject(subjectId);

	}

}
