package com.pgrg.demo.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;


    public Users(Users users) {
        this.id = users.getId();
        this.name = users.getName();
    }
}
