package com.awto.testAwto.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.awto.testAwto.repositories.entity.AwLogModel;

@Repository
public interface AwLogRepository extends JpaRepository<AwLogModel, Integer>{

	@Query("SELECT p FROM AwLogModel p, AwHashtagLogModel n WHERE n.id = ?1")
	List<AwLogModel> findByHashtagId(Integer id);	
}
