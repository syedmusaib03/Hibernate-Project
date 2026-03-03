package com.syedmusaib;

import com.syedmusaib.Entities.Student;
import com.syedmusaib.Service.StudentService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class SecondLevelCache {
    public static void main(String[] args) {



        StudentService studentService = new StudentService();
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session1 = sessionFactory.openSession();
        Transaction transaction = session1.beginTransaction();

        Student s1 = (Student) session1.get(Student.class, 1);
        System.out.println(s1);


        Student s2 = session1.get(Student.class, 1);
        System.out.println(s2);

        System.out.println("-----------------------------------------");
        System.out.println(s1==s2);

        Session session2 = sessionFactory.openSession();
        Transaction transaction1 = session2.beginTransaction();
        Student s21 = (Student) session2.get(Student.class, 1);
        System.out.println(s21);




    }
}
