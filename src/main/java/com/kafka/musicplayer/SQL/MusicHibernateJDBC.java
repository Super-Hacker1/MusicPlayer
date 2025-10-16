package com.kafka.musicplayer.SQL;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import com.kafka.musicplayer.model.MusicClass;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MusicHibernateJDBC {
    private static final SessionFactory sessionFactory;

    static{
        try{
            //loading confguration
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

            //service registry
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex){
            System.err.println("Initial SessionFactory creation failed" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public List<MusicClass> findAll(){
        List<MusicClass> musicList = new ArrayList<>();

        try(Session session = sessionFactory.openSession()){
            musicList = session.createQuery("FROM musicDetails", MusicClass.class).list();

            for(MusicClass i : musicList){
                System.out.println(i);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return musicList;
    }
}
