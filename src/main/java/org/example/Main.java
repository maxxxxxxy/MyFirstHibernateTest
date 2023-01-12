package org.example;

import Factory.HibernateUtil;
import entity.Users;
import org.hibernate.Session;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args)  throws SQLException {
        //сразу получаем готовый SessionFactory и сразу создаем сессию
        Session session = HibernateUtil.getSessionFactory().openSession();
        //открыть транзакцию
        session.getTransaction().begin();

        Users user = new Users();
        user.setName("Max");
        user.setLastname("Polyakov");
        user.setUsername("by_maxxxxxxy");




        session.save(user);
        session.getTransaction().commit(); //сохранить иземенения
        session.close(); // закрыть транзакцию

        HibernateUtil.shutdown();

        
    }
}