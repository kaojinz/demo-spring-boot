package com.example.service;

import com.example.mapper.AuthorMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Service
@Transactional
public class AuthorService
{
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private AuthorMapper authorMapper;

	public List<Map<String, Object>> selectAll() {
		return authorMapper.selectAuthorAll();
	}

	public Map<String, Object> selectMapById(Integer id) {
		return authorMapper.selectMapById(id);
	}

	// Test Transactional with fail save file
	// 트랜젝션 테스트 insert를 후 파일 저장이 실패 하면 앞의 insert rollback 되어 이전 상태로 됨.
	public void insertByMapAndRequst(Map<String, Object> map) {
		authorMapper.insertAuthorMap(map);
		System.out.println(map.toString());
		if(!saveFile()){
			throw new RuntimeException("not save file");
		}
	}

	public boolean saveFile() {
		return false;
	}

}
