package com.taskcloud.dto;

import lombok.Getter;

@Getter
public class MemberCreateRequest {

    private String name;
    private String email;
    private Integer birthday;
    private String mbti;
}
