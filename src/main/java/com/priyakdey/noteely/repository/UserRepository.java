package com.priyakdey.noteely.repository;

import com.priyakdey.noteely.model.User;
import java.util.Optional;

/**
 * Defines all persistence related methods for {@link User}.
 *
 * @author Priyak Dey
 */
public interface UserRepository {

    /**
     * Persists the {@link User} in the database.
     *
     * @param user {@link User}
     * @return user with the id populated.
     */
    User save(User user);

    /**
     * Finds and returns the user by username.
     *
     * @param username String
     * @return user details wrapped in {@link Optional}
     */
    Optional<User> findByUsername(String username);

}
