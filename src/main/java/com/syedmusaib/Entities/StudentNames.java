package com.syedmusaib.Entities;


import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class StudentNames {

    private String fName;
    private String mName;
    private String lNAme;
}
