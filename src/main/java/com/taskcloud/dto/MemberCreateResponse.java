package com.taskcloud.dto;

import lombok.Getter;

@Getter
public class MemberCreateResponse {

    private final Long id;
    private final String name;
    private final String email;
    private final Integer birthday;
    private final String mbti;

    public MemberCreateResponse(
            Long id,
            String name,
            String email,
            Integer birthday,
            String mbti
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.mbti = mbti;
    }
}
