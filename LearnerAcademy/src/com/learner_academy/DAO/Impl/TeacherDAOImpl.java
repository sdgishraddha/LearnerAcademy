package com.learner_academy.DAO.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.learner_academy.DAO.TeacherDAO;
import com.learner_academy.model.Teacher;

public class TeacherDAOImpl implements TeacherDAO {

	Configuration configuration = new Configuration().configure();
	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
			.applySettings(configuration.getProperties());
	SessionFactory factory = configuration.buildSessionFactory(builder.build());

	@Override
	public Teacher createTeacher(Teacher teacher) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(teacher);
		transaction.commit();
		session.close();
		return teacher;
	}

	@Override
	public Teacher getTeacherById(int teacherId) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Teacher teacher = (Teacher) session.get(Teacher.class, teacherId);
		transaction.commit();
		session.close();
		return teacher;
	}

	@Override
	public List<Teacher> getAllTeachers() {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		List<Teacher> teacherList = session.createQuery("from com.learner_academy.model.Teacher").list();
		transaction.commit();
		session.close();
		return teacherList;
	}

	@Override
	public Teacher updateTeacher(Teacher teacher) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(teacher);
		transaction.commit();
		session.close();
		return teacher;
	}

	@Override
	public void removeTeacher(int teacherId) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Teacher tea = new Teacher();
		tea.setTeacherId(teacherId);
		session.delete(tea);
		transaction.commit();
		session.close();

	}

}
