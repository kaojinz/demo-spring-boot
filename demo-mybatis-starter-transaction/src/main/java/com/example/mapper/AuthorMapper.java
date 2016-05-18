/**
 *    Copyright 2015-2016 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Mapper
@Service
public interface AuthorMapper {

	// resources.com.example.mapper AuthorMapper.xml의 같은 이름의 id와 연결, path도 같아야 함.
	List<Map<String, Object>> selectAuthorAll();

	// annotaion query
	@Select("select * from author where id=#{id}")
	Map<String, Object> selectMapById(Integer id);

	// Integer는 null 처리가 가능함.
	Map<String, Object> selectMapById2(Integer id);

	int insertAuthorMap(Map map);
}
