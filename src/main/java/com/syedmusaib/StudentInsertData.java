package com.syedmusaib;

import com.syedmusaib.Entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Scanner;

public class StudentInsertData {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;


        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name");
        String studentName = sc.nextLine();

        System.out.println("Enter the college");
        String studentCollege = sc.nextLine();

        System.out.println("Enter the father name");
        String studentFatherName = sc.nextLine();

        System.out.println("Enter the phone number");
        String studentPhoneNo = sc.nextLine();


        Student s1 = new Student();
        s1.setName(studentName);
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
