package Factory;

import lombok.Getter;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

import java.io.File;


//спец. Java класс для иниц-ии Hibernate
public class HibernateUtil {
    //фабрика для создания сессий
    private static final SessionFactory sessionFactory = buildSessionFactory();

    //этот метод вызывается автоматически, т.к он вызывается из статической переменной
    private static SessionFactory buildSessionFactory(){
        try{
            return new Configuration().configure(new File("src\\main\\resources\\hibernate.cfg.xml")).buildSessionFactory();
        }catch(Throwable ex){
            System.err.println("Initial SessionFactory creation failed."+ex);
            throw new ExceptionInInitializerError();
        }
    }

    // вызываем этот метод когда, потребуется SessionFactory
    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null) buildSessionFactory();

        return sessionFactory;
    }
    //закрыть все соединения с помощью SessionFactory
    public static void shutdown(){
        getSessionFactory().close();
    }
}
