package com.learner_academy.DAO.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.learner_academy.DAO.ClassesDAO;
import com.learner_academy.model.Classes;

public class ClassesDAOImpl implements ClassesDAO {

	Configuration configuration = new Configuration().configure();
	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
			.applySettings(configuration.getProperties());
	SessionFactory factory = configuration.buildSessionFactory(builder.build());

	@Override
	public Classes createClasses(Classes classes) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(classes);
		transaction.commit();
		session.close();
		return classes;
	}

	@Override
	public Classes getClassesById(int classId) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Classes classes = (Classes) session.get(Classes.class, classId);
		transaction.commit();
		session.close();
		return classes;
	}

	@Override
	public List<Classes> getAllClasses() {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		List<Classes> classesList = session.createQuery("from com.learner_academy.model.Classes").list();
		transaction.commit();
		session.close();
		return classesList;
	}

	@Override
	public Classes updateClasses(Classes classes) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(classes);
		transaction.commit();
		session.close();
		return classes;
	}

	@Override
	public void removeClasses(int classId) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Classes cla = new Classes();
		cla.setClassId(classId);
		session.delete(cla);
		transaction.commit();
		session.close();
	}

}
