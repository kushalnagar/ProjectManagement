package com.infiniteskills.mvc.dao;

import java.util.List;

import com.infiniteskills.mvc.data.entities.Project;

public interface ProjectDAO {
	
	public void save(Project p);
	
	public List<Project> list();
	
	public Project find(Long projectId);
	
}
