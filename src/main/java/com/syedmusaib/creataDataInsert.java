package com.syedmusaib;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class creataDataInsert {
    public static void main(String[] args) {
        Session session = null;
        session = HibernateUtil.getSessionFactory().openSession();
     Transaction transaction= session.beginTransaction();


        try {
            Student s1 = new Student();
            s1.setName("Syed Musaib");
            s1.setCollege("BIET");
            s1.setFathername("Syed Hassain");
            s1.setPhoneno("9901534307");
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
