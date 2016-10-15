package com.infiniteskills.mvc.data.services;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.infiniteskills.mvc.dao.ProjectDAO;
import com.infiniteskills.mvc.data.entities.Project;
import com.infiniteskills.mvc.data.entities.Sponsor;

public class ProjectService {

		
		private List<Project> projects = new LinkedList<>(); 
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		ProjectDAO projectDAO = context.getBean(ProjectDAO.class);
		
		public ProjectService(){
			
			Project javaProject = this.createProject("Java Project", "This is a Java Project");
			projectDAO.save(javaProject);
			Project javascriptProject = this.createProject("Javascript Project", "This is a Javascript Project");
			
			projectDAO.save(javascriptProject);
			Project htmlProject = this.createProject("HTML Project", "This is an HTML project");
			projectDAO.save(htmlProject);
			
			//this.projects.addAll(Arrays.asList(new Project[]{javaProject, javascriptProject, htmlProject}));
			
		}
		
		public List<Project> findAll(){
			return projectDAO.list();
		}
		
		public Project find(Long projectId){			
			return projectDAO.find(projectId);
		}
		
		public void save(Project project){
			projectDAO.save(project);
		}
		
		private Project createProject(String title, String description) {
			Project project = new Project();
			project.setName(title);
			project.setAuthorizedFunds(new BigDecimal("100000"));
			project.setAuthorizedHours(new BigDecimal("1000"));
			//project.setProjectId(projectId);
			project.setSpecial(false);
			project.setType("multi");
			project.setYear("2015");
			project.setDescription(description);
			return project;
		}
		
		
		
}
