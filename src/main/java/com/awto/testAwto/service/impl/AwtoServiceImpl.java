package com.awto.testAwto.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.awto.testAwto.dto.AwHashtag;
import com.awto.testAwto.dto.AwLog;
import com.awto.testAwto.exceptions.ResourceNotFoundException;
import com.awto.testAwto.repositories.AwHashTagLogRepository;
import com.awto.testAwto.repositories.AwHashTagRepository;
import com.awto.testAwto.repositories.AwLogRepository;
import com.awto.testAwto.repositories.entity.AwHashtagLogModel;
import com.awto.testAwto.repositories.entity.AwHashtagModel;
import com.awto.testAwto.repositories.entity.AwLogModel;
import com.awto.testAwto.repositories.responds.RespondLog;
import com.awto.testAwto.service.AwtoService;

@Service
public class AwtoServiceImpl implements AwtoService{

	@Autowired
	private AwHashTagLogRepository repo3;
	
	@Autowired
	private AwLogRepository repo1;
	
	@Autowired
	private AwHashTagRepository repo2;
	
	
	@Override
	public Boolean createLog(AwLog req) {
		AwLogModel awLogModel = new AwLogModel();
		List<AwHashtag> list = new ArrayList<AwHashtag>();
		
		req.getHashtags().forEach(a->{
			AwHashtag model = new AwHashtag(); 
			model.setDescription(a);
			list.add(model);
		});
		
		/*Esto es lo que llega para guardar en el repo 1*/
		awLogModel.setCreationDate(LocalDate.now());
		awLogModel.setDetails(req.getDetails());
		awLogModel.setHost(req.getHost());
		awLogModel = repo1.save(awLogModel);
		
		/*Este llena el repo 2*/
		
		for(AwHashtag p : list) {
			
			AwHashtagModel model = new AwHashtagModel();
			model.setDescription(p.getDescription());
			model = repo2.save(model);
			
			AwHashtagLogModel awHashtagLogModel = new AwHashtagLogModel();
			AwLogModel modelId = repo1.findById(awLogModel.getId()).orElseThrow(() -> new ResourceNotFoundException("Not found"));
			if(modelId.getId() != awLogModel.getId()) {
				awHashtagLogModel.setAwLogModel(awLogModel);
			}
			awHashtagLogModel.setAwHashtagModel(model);
			repo3.save(awHashtagLogModel);
		}		
		return true;
	}


	@Override
	public List<RespondLog> findById(Integer id) {
		List<RespondLog> responds = new ArrayList<RespondLog>();
		repo1.findByHashtagId(id).forEach(p -> {
			RespondLog model = new RespondLog();
			model.setId(p.getId());
			model.setCreationDate(p.getCreationDate());
			model.setHost(p.getHost());
			model.setDetails(p.getDetails());
			responds.add(model);
		});		
		
		return responds;
	}
	
	public List<AwHashtagLogModel> findByHashTagId(Integer id){
		List<AwHashtagLogModel> list = new ArrayList<AwHashtagLogModel>();
		list = repo3.findByHashTagId(id);
		return null;
	}


	@SuppressWarnings("unused")
	@Override
	public Boolean updateHashTag(AwHashtag awReq) {

		AwHashtagModel model = repo2.findById(awReq.getId()).orElseThrow(() -> new ResourceNotFoundException("Not found hashtag with id = " + awReq.getId()));
		model.setId_tag(awReq.getId());
		model.setDescription(awReq.getDescription());
		repo2.save(model);
		if(model != null) {
			return true;
		}
		return false;
	}

}
