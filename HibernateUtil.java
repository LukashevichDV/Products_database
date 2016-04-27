package ru.mail.LukashevichDV;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import ru.mail.LukashevichDV.entity.GroupProduct;
import ru.mail.LukashevichDV.entity.Product;


public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new AnnotationConfiguration().addPackage("ru.mail.LukashevichDV.entity")
                    .addAnnotatedClass(Product.class).addAnnotatedClass(GroupProduct.class).configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void close() {
        sessionFactory.close();
    }
}