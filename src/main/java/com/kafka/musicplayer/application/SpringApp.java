package com.kafka.musicplayer.application;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import com.kafka.musicplayer.SQL.MusicDB;

import java.sql.SQLException;

@SpringBootApplication
public class SpringApp {
    public static void main(String[] args)throws SQLException{
        SpringApplication.run(SpringApp.class, args);
        MusicDB.Insert("Blinding Lights", "The Weeknd", "After Hours", "R&B", "2019", "3:24");
    }

}
