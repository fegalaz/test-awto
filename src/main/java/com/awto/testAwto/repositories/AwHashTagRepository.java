package com.awto.testAwto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.awto.testAwto.repositories.entity.AwHashtagModel;

@Repository
public interface AwHashTagRepository extends JpaRepository<AwHashtagModel, Integer>{

}
