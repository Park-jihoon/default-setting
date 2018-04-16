package com.pohinian.springvue.member;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

/**
 * Created by Park Ji Hoon (pohinian@gmail.com) on 2018. 4. 16..
 */
@Entity
public class Member {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String password;

    public Member() {
        super();
    }

    public Member(Long id, String name, String password) {
        super();
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public Member(String name, String password) {
        super();
        this.name = name;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
