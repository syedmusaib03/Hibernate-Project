package com.syedmusaib;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Scanner;

public class CertificateDataInsert {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Transaction transaction = null;


        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Student Name to add Certificate :");
        String studentName = sc.nextLine();

        System.out.println("Enter the Certificate Title :");
        String certificateTitle = sc.nextLine();


        System.out.println("About the Certification ");
        String certificateAbout = sc.nextLine();

        System.out.println("Enter the Certification Link");
        String certificationLink = sc.nextLine();

        Certificate certificate = new Certificate();

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            String hql = "from Student where name = :name";

            Student student = session.createQuery(hql, Student.class)
                    .setParameter("name", studentName)
                    .uniqueResult();

            if (student == null) {
                System.out.println("Student Does Not Exist");
                return;
            }

            Certificate certificate1 = new Certificate();
            certificate1.setTitle(certificateTitle);
            certificate1.setAbout(certificateAbout);
            certificate1.setLink(certificationLink);

            certificate1.setStudent(student);
            student.getCertificate().add(certificate1);

            session.merge(student);
            transaction.commit();
            System.out.println("Certifications of "+studentName+" Saved SuccesFully");

        }catch (Exception e){
            if (transaction != null  && transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }
}
