package com.sts.beans.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.sts.beans.models.Users;

@Repository
public class UsersRepository {

	@Autowired
	private BaseRepository<Users> baseRepository;

	public List<Users> getAllUsers() {
		return baseRepository.findAll(Users.class);
	}

	public Users getUserByEmail(String email) {
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(email));
		return baseRepository.findOne(Users.class, query);
	}

}
