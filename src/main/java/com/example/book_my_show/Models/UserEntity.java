package com.example.book_my_show.Models;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.repository.cdi.Eager;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int age;

    @Column(unique = true,nullable = false)
    private String email;


    @NonNull
    @Column(unique = true)
    private String mobNo;

    private String address;


}
