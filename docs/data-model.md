User:

|          Field          |    Type    |                                                                                                  Description                                                                                                  |
|:-----------------------:|:----------:|:-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|
|           _id           |     ID     |                                                                                                   Mongo id                                                                                                    |
|        username         |   String   |                                                                                    User email will be used as the username                                                                                    |
|        password         |   String   |                                                                                          Hashed password of the user                                                                                          |
|          roles          | List[Role] |                                                                                    List of authorities granted to the user                                                                                    |
|   isAccountNonExpired   |  boolean   |           Indicates whether the user's account has expired. An expired account cannot be authenticated. true if the user's account is valid (ie non-expired), false if no longer valid (ie expired)           |
|   isAccountNonLocked    |  boolean   |                                   Indicates whether the user is locked or unlocked. A locked user cannot be authenticated. true if the user is not locked, false otherwise                                    |
| isCredentialsNonExpired |  boolean   | Indicates whether the user's credentials (password) has expired. Expired credentials prevent authentication. true if the user's credentials are valid (ie non-expired), false if no longer valid (ie expired) |
|        isEnabled        |  boolean   |                                   Indicates whether the user is enabled or disabled. A disabled user cannot be authenticated. true if the user is enabled, false otherwise                                    
|          name           |   String   |                                                                                     Full name of the user / Display Name                                                                                      |
| emailVerificationToken  |   String   |                                                                                         Generated to verify the user                                                                                          |

    boolean isAccountNonExpired();

    boolean isAccountNonLocked();

    boolean isCredentialsNonExpired();

    boolean isEnabled();

Role:

| Field |  Type  |               Description                |
|:-----:|:------:|:----------------------------------------:|
|  _id  | String |                 Mongo id                 |
| name  | String | Name of the role - ROLE_ADMIN, ROLE_USER |

Note:

|    Field    |     Type     |                                   Description                                   |
|:-----------:|:------------:|:-------------------------------------------------------------------------------:|
|     _id     |    String    |                                    Mongo id                                     |
|   content   |    String    |                               Content of the note                               |
|   ownerId   |    String    |                              User id of the owner                               |
| sharedWith  | List[String] |                     List of users ids with read permission                      |
| contentHash |     int      |     contentHash helps identify any change in the content, before a db flush     |
|   version   |     int      | version helps push notifications to users with read only permission to the note |
|  createdAt  |     long     |                                created timestamp                                |
|  updatedAt  |     long     |                                updated timestamp                                |

