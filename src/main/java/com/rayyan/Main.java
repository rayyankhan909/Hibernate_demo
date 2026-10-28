package com.rayyan;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        Alien a1 = new Alien();
//        a1.setAid(103);
//        a1.setAname("Rashid");
//        a1.setTech("SQL");



        SessionFactory factory = new Configuration()
                .addAnnotatedClass(com.rayyan.Alien.class)
                .configure()
                .buildSessionFactory();

        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        Alien a1 = session.find(Alien.class, 103);

        System.out.println(a1);

//        session.merge(a1);

        session.remove(a1);

        transaction.commit();

        session.close();
        factory.close();

    }
}