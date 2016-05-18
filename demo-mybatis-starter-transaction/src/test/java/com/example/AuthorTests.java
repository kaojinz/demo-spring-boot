package com.example;

import com.example.mapper.AuthorMapper;
import com.example.service.AuthorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class AuthorTests {

	@Autowired
	AuthorMapper authorMapper;

	@Autowired
	AuthorService authorService;

	@Test
	public void serviceLoads() {
		List<Map<String, Object>> list = authorService.selectAll();
		for (Map map:list) {
			System.out.println(map.toString());
		}

		System.out.println("====================");
		Map<String, Object> map = authorService.selectMapById(1);
		System.out.println(map.toString());
	}

	@Test
	public void mapperLoads() {
		List<Map<String, Object>> list = authorMapper.selectAuthorAll();
		for (Map map:list) {
			System.out.println(map.toString());
		}
	}

	@Test
	public void mapperByIdLoads() {
		Map<String, Object> map = authorMapper.selectMapById(1);
		System.out.println(map.toString());
	}

	@Test
	public void selectMapById2Loads() {
		Map<String, Object> map = authorMapper.selectMapById2(1);
		System.out.println(map.toString());
	}

	@Test
	public void insertAuthorMapLoads() {
		Map<String, Object> map = new HashMap();
//		map.put("ID", "3");
		map.put("FIRST_NAME", "gildong");
		map.put("LAST_NAME", "Hong");
		map.put("DATE_OF_BIRTH", "1900-01-01");
		map.put("YEAR_OF_BIRTH", "1900");
		map.put("DISTINGUISHED", "9");

		authorMapper.insertAuthorMap(map);
		System.out.println(map.toString());
	}

	// 트랜젝션 테스트 insert를 후 파일 저장이 실패 하면 앞의 insert rollback
	@Test
	public void insertByMapAndRequestLoads() {
		Map<String, Object> map = new HashMap();
//		map.put("ID", "3");
		map.put("FIRST_NAME", "gildong");
		map.put("LAST_NAME", "Hong");
		map.put("DATE_OF_BIRTH", "1900-01-01");
		map.put("YEAR_OF_BIRTH", "1900");
		map.put("DISTINGUISHED", "9");

		authorService.insertByMapAndRequst(map);
		System.out.println(map.toString());
	}

}
