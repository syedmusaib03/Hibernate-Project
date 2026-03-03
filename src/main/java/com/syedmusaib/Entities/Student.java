package com.syedmusaib.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "certificate")
@Entity
@Table(name = "Student")

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int studentId;

    @Column(name = "Student_name", length = 100, unique = true)
    private StudentNames name;

    @Column(name = "College_name", length = 100, nullable = true)
    private String college;

    @Column(name = "Student_Phno")
    private String phoneno;

    @Column(name = "Father_name")
    private String fathername;

    private boolean active = true;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.EAGER,orphanRemoval = true)
    private List<Certificate> certificate = new ArrayList<>();


}
