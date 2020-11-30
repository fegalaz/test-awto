package com.awto.testAwto.service;

import java.util.List;

import com.awto.testAwto.dto.AwHashtag;
import com.awto.testAwto.dto.AwLog;
import com.awto.testAwto.repositories.entity.AwHashtagLogModel;
import com.awto.testAwto.repositories.responds.RespondLog;

public interface AwtoService {

	Boolean createLog(AwLog req);
	
	List<RespondLog> findById(Integer id);

	List<AwHashtagLogModel> findByHashTagId(Integer id);

	Boolean updateHashTag(AwHashtag awReq);
}
