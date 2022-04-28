package com.hello.servlet.domain.member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Member {

    private Long id;
    private String userName;
    private int age;

    public Member(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }

}
