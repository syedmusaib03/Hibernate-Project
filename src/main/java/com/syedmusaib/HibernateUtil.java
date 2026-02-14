package com.syedmusaib;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory factory;


    static {
        try {
            if (factory == null) {
                factory = new Configuration()
                        .addAnnotatedClass(com.syedmusaib.Student.class)
                        .configure()
                        .buildSessionFactory();
            }
        }catch (Exception e){
            throw new ExceptionInInitializerError(e);

        }
    }



    public static SessionFactory getSessionFactory() {
        return factory;
    }


    public static  void shutdown() {
        if (factory != null) factory.close();

    }
}
