package com.yoprogramo.portfolioweb.Repository;

import com.yoprogramo.portfolioweb.Model.ProjectCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectCRepository extends JpaRepository<ProjectCard, Integer> {

}
