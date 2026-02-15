package com.syedmusaib;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Collections;
import java.util.List;

public class StudentService {

    Transaction transaction = null;
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public void saveStudent(Student student) {
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(student);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public Student getById(int studentId) {
        try (Session session = sessionFactory.openSession()) {
            Student student = session.get(Student.class, studentId);
            return student;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public Student updateStudent(int studentId, Student student) {
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Student oldStudent = session.get(Student.class, studentId);
            if (oldStudent != null) {
                oldStudent.setName(student.getName());
                oldStudent.setCollege(student.getCollege());
                oldStudent.setPhoneno(student.getPhoneno());
                oldStudent.setFathername(student.getFathername());
                session.merge(oldStudent);
                transaction.commit();
                return oldStudent;
            } else {
                System.out.println("Student with ID " + studentId + " not found.");
                return null;
            }


        }
    }


    public void deleteByStudentId(int studentId) {
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Student deleteStudent = session.get(Student.class, studentId);
            if (deleteStudent != null) {
                session.remove(deleteStudent);
                transaction.commit();
            } else {
                System.out.println("Student Not Found");
            }
        }

    }


    public List<Student> getAllStudentsHQL() {
        try (Session session = sessionFactory.openSession()) {
            Query<Student> query = session.createQuery("from student", Student.class);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
