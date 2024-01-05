package com.priyakdey.noteely.repository.impl;

import com.priyakdey.noteely.model.User;
import com.priyakdey.noteely.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 * Concrete implementation of {@link UserRepository}. All methods here, helps
 * database operations related to {@link User}. This repository contains logic to
 * operate on mongodb for specific operations.
 *
 * @author Priyak Dey
 */
public class UserRepositoryImpl implements UserRepository {

    private final MongoTemplate mongoTemplate;

    public UserRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    /**
     * Persists the {@link User} in the database.
     *
     * @param user {@link User}
     * @return user with the id populated.
     */
    @Override
    public User save(User user) {
        return mongoTemplate.save(user);
    }

    /**
     * Finds and returns the user by username.
     *
     * @param username String
     * @return user details wrapped in {@link Optional}
     */
    @Override
    public Optional<User> findByUsername(String username) {
        Criteria criteria = Criteria.where("username").is(username);
        Query query = new Query(criteria);
        User user = mongoTemplate.findOne(query, User.class, "notes");
        return Optional.ofNullable(user);
    }
}
