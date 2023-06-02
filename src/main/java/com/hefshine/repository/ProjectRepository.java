package com.hefshine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hefshine.dto.ProjectDashBoardDTO;
import com.hefshine.model.ProjectDetails;

public interface ProjectRepository extends JpaRepository<ProjectDetails, Integer>{
	int countByProjectName(String name);

	@Query(value = "select (count(*)) as totalCount,\r\n"
			+ "(SELECT count(*) FROM project_details where status='Running') as runningCount,\r\n"
			+ "(SELECT count(*) FROM project_details where status='Close') as closeCount,\r\n"
			+ "(SELECT count(*) FROM project_details where status='Cancelled') as cancleCount,\r\n"
			+ "(SELECT count(*) FROM project_details where status='Register') as registerCount\r\n"
			+ " from project_details;",nativeQuery = true)
	ProjectDashBoardDTO getCountDetailsOfProject();
	
	
	
	
	
//	@Query(value = "SELECT count(*) FROM project_details where status='Close'",nativeQuery = true)
//	long getCountCloseProject();
//	@Query(value = "SELECT count(*) FROM project_details where status='Cancelled'",nativeQuery = true)
//	long getCountCancelledProject();

}
