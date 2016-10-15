package com.infiniteskills.mvc.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.infiniteskills.mvc.data.entities.Project;

public class ProjectDAOImpl implements ProjectDAO{
	
	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
	@Override
	public void save(Project p) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(p);
		tx.commit();
		session.close();
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Project> list() {
		Session session = this.sessionFactory.openSession();
		List<Project> projectList = session.createQuery("from Project").list();
		session.close();
		return projectList;
	}
	
	@Override
	public Project find(Long projectId){
		String hql = "from Project where projectId ="+projectId;
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery(hql);
		List<Project> listProject = query.list();
		 
		for (Project project : listProject) {
		    System.out.println(project.getName());
		}		
		return listProject.get(0);
	}
	
}
