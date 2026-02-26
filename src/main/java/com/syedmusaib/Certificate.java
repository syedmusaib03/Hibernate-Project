package com.syedmusaib;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "student")
@Entity
@Table(name = "Certificate")
public class Certificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long certificateId;



    private String title;

    private String about;

    private String link;


    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;


}
