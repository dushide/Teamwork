package com.lfk.repository;

import com.lfk.model.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProjectRepository extends JpaRepository<ProjectEntity,Integer> {

    @Query("select pro from ProjectEntity pro where pro.userByUserId.id=?1")
    List<ProjectEntity> findByUserByUserId(int userId);

    @Modifying
    @Transactional
    @Query("update ProjectEntity pro set pro.projectName=?1,pro.proDescription=?2,pro.deadline=?3 where pro.id=?4")
    void updateProject(String projectName,String projectDescription,String deadline,int id);
}
