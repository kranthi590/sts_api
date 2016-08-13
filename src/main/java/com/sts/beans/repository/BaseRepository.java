package com.sts.beans.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class BaseRepository<T> {

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<T> findAll(Class<T> type) {

		return mongoTemplate.findAll(type);
	}

	public T findOne(Class<T> type, Query query) {
		System.out.println("Find One by Query Object: " + query);
		return mongoTemplate.findOne(query, type);
	}
}
