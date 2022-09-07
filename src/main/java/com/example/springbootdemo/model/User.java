package com.example.springbootdemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="user_db")
public class User{
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    private String address;
    private int age;
}
