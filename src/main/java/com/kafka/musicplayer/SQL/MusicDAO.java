package com.kafka.musicplayer.SQL;
import com.kafka.musicplayer.model.MusicClass;
import com.kafka.musicplayer.service.Service;

import java.sql.SQLException;
import java.util.List;

//MVC Design -> Model, View, Controller

public class MusicDAO implements Service {
    public List<MusicClass> findall() throws SQLException {
        MusicDB musicdb = new MusicDB();
        List<MusicClass> allmusic = musicdb.findall();
        return allmusic;
    }
}
