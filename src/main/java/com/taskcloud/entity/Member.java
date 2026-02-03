package com.taskcloud.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "members")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(unique = true)
    private String email;

    private Integer birthday;
    private String mbti;

    public Member(String name, String email, Integer birthday, String mbti) {
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.mbti = mbti;
    }

}
