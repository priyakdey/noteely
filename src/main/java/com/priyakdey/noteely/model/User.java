package com.priyakdey.noteely.model;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * {@link User} represents the domain model of a single user.
 * This class contains all fields related to user credentials and metadata.
 *
 * @author Priyak Dey
 */
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Document("users")
public class User {

    /**
     * mongodb unique key
     */
    @Id
    private String id;

    /**
     * The username used to authenticate the user. Cannot return null.
     * This is the user email address.
     */
    @Indexed(unique = true, name = "user_username_index")
    private String username;

    /**
     * The password used to authenticate the user.
     */
    private String password;

    /**
     * The set of{@link Role} granted to the user.
     */
    @DBRef
    private Set<Role> roles;

    /**
     * Indicates whether the user's account has expired. An expired account cannot be authenticated.
     * This field is set to true if user's account is not expired.
     */
    private boolean isAccountNonExpired;

    /**
     * Indicates whether the user is locked or unlocked. A locked user cannot be authenticated.
     * This field is set to true, if account is not locked.
     */
    private boolean isAccountNonLocked;

    /**
     * Indicates whether the user's credentials (password) has expired. Expired credentials prevent authentication.
     * This field is set to true, if the user credentials is not expired.
     */
    private boolean isCredentialsNonExpired;

    /**
     * Indicates whether the user is enabled or disabled. A disabled user cannot be authenticated.
     * This field is set to true if the user is enabled, false otherwise
     */
    private boolean isEnabled;

    /**
     * Full name of the user. This field will be used to display user details in the ui.
     */
    private String name;

    /**
     * The token used for email verification.
     */
    private String emailVerificationToken;

    /**
     * Timestamp to show when user was created.
     */
    private long createdAt;

    /**
     * Timestamp to show when the account was last updated.
     * This field will be only to determine how old the latest password is, and
     * can be used for password rotation.
     */
    private long updatedAt;

}
