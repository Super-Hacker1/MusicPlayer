package com.kafka.musicplayer.service;

import com.kafka.musicplayer.SQL.MusicDB;
import com.kafka.musicplayer.model.MusicClass;

import java.sql.SQLException;
import java.util.List;

public interface Service {
    List<MusicClass> findall() throws SQLException;

}




