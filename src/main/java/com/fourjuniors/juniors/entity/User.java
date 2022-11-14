package com.fourjuniors.juniors.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "users")
public class User implements Serializable {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "portfolio")
    private String portfolio;

    @Column(name = "email")
    private String email;

    @Column(name = "profile")
    private String profile;

    @Column(name = "experience")
    private String experience;

    @Column(name = "stack")
    private String stack;

    // TODO:Roles

}
