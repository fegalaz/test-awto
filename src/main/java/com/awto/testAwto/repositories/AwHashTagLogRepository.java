package com.awto.testAwto.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.awto.testAwto.repositories.entity.AwHashtagLogModel;

@Repository
public interface AwHashTagLogRepository extends JpaRepository<AwHashtagLogModel, Integer>{
	
	@Query("SELECT n FROM AwHashtagLogModel n WHERE n.id_tag = ?1")
	List<AwHashtagLogModel> findByHashTagId(Integer id);
}
