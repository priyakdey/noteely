package com.priyakdey.noteely.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * {@link Role} represents the application permissions which an user can hold.
 *
 * @author Priyak Dey
 */
@Getter
@Setter
@NoArgsConstructor
@Document("roles")
public class Role {

    /**
     * mongodb id
     */
    @Id
    private String id;

    /**
     * Ref: {@link ERole}
     */
    private ERole name;

    public static Role of(ERole eRole) {
        Role role = new Role();
        role.name = eRole;
        return role;
    }
}
