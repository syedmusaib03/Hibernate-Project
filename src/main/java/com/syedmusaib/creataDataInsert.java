package com.syedmusaib;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Scanner;

public class creataDataInsert {
    public static void main(String[] args) {
        Session session = null;
        session = HibernateUtil.getSessionFactory().openSession();
     Transaction transaction= session.beginTransaction();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name");
        String n = sc.nextLine();

        System.out.println("Enter the college");
        String col = sc.nextLine();
        System.out.println("Enter the father name");
        String fname = sc.nextLine();
        System.out.println("Enter the phone number");
        String pno = sc.nextLine();




        try {
            Student s1 = new Student();
            s1.setName(n);
            s1.setCollege(col);
            s1.setFathername(fname);
            s1.setPhoneno(pno);
            s1.setActive(true);

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
        finally {
            if (session != null)session.close();
            HibernateUtil.shutdown();
        }
    }
}
