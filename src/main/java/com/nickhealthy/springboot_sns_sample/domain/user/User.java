package com.nickhealthy.springboot_sns_sample.domain.user;

import com.nickhealthy.springboot_sns_sample.domain.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false)
    private String password;

    private User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static User create(String username, String password) {
        return new User(username, password);
    }
}
