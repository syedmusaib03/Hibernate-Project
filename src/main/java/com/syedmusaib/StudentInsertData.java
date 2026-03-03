package com.syedmusaib;

import com.syedmusaib.Entities.Student;
import com.syedmusaib.Entities.StudentNames;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Scanner;

public class StudentInsertData {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;

        StudentNames sn = new StudentNames();
        Student s1 = new Student();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the First name");
        String fname = sc.nextLine();

        System.out.println("Enter the Middle name");
        String mname = sc.nextLine();

        System.out.println("Enter the Last name");
        String lname = sc.nextLine();

        System.out.println("Enter the college");
        String studentCollege = sc.nextLine();

        System.out.println("Enter the father name");
        String studentFatherName = sc.nextLine();

        System.out.println("Enter the phone number");
        String studentPhoneNo = sc.nextLine();

        sn.setFName(fname);
        sn.setMName(mname);
        sn.setLNAme(lname);

        s1.setName(sn);
        s1.setCollege(studentCollege);
        s1.setFathername(studentFatherName);
        s1.setPhoneno(studentPhoneNo);
        s1.setActive(true);


        try(Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(s1);
            transaction.commit();
            if (s1 != null)System.out.println("Inserted Data Successfully");
            else System.out.println("Data Not Inserted");

        }catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }



    }
}
