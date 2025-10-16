package com.kafka.musicplayer.controller;
import org.springframework.web.bind.annotation.*;
import com.kafka.musicplayer.SQL.MusicDAO;
import com.kafka.musicplayer.SQL.MusicDB;
import com.kafka.musicplayer.service.Service;
import com.kafka.musicplayer.model.MusicClass;
import java.sql.*;

import java.util.List;

@RestController
@RequestMapping("/musicList")
public class AppController {
    @GetMapping
    public List<MusicClass> getallMusic()throws SQLException{
        Service service = new MusicDAO();
        return service.findall();

    }

}
