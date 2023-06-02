package com.hefshine.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hefshine.dto.ProjectDashBoardDTO;
import com.hefshine.exception.ResourceNotFound;
import com.hefshine.model.ProjectDetails;
import com.hefshine.model.User;
import com.hefshine.repository.ProjectRepository;


@CrossOrigin
@RestController
@RequestMapping("con2")
public class Controller2 {
	
	@Autowired
	ProjectRepository projectRepository;
	
	@PostMapping("/addProject")
	public boolean addProject(@RequestBody ProjectDetails project) {
		
		try
		{
			int count = projectRepository.countByProjectName(project.getProjectName());
			if(count==0)
			{
				projectRepository.save(project);
			return true;
			}
			else
				return false;
		}
		catch (Exception e) {

			e.printStackTrace();
			return false;
		}
	}
	
	@GetMapping("getProjectDetails")
	public  List<ProjectDetails> getAllProjectDetails(){
		
		return projectRepository.findAll();
	}
	
	@GetMapping("changeStatus/{proId}/{status}")
	public boolean changeProjectStatus(@PathVariable int proId,@PathVariable String status)
	{

ProjectDetails project =projectRepository.findById(proId)
.orElseThrow(() ->new ResourceNotFound("Project dose not exist with id: "+proId));
project.setStatus(status);
projectRepository.save(project);
		
		return true;
	}
	
	@GetMapping("totalPro")
	public ProjectDashBoardDTO getTotaleProject() {
		
		ProjectDashBoardDTO boardDTO = projectRepository.getCountDetailsOfProject();
		System.out.println(boardDTO.getTotalCount());
		System.out.println(boardDTO.getRunningCount());
		System.out.println(boardDTO.getCloseCount());
		System.out.println(boardDTO.getCancleCount());
		return boardDTO;
		
	}
	 
	
	

}
