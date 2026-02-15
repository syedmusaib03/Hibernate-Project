package com.syedmusaib;

import jakarta.persistence.*;
import org.hibernate.metamodel.mapping.EntityAssociationMapping;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int studentId;

    @Column(name = "Student_name", length = 100, unique = true)
    private String name;

    @Column(name = "College_name", length = 100, nullable = true)
    private String college;

    @Column(name = "Student_Phno")
    private String phoneno;

    @Column(name = "Father_name")
    private String fathername;

    private boolean active = true;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY,orphanRemoval = true)
    private List<Certificate> certificate = new ArrayList<>();


    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
