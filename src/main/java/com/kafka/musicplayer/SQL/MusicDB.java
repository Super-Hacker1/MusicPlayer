package com.kafka.musicplayer.SQL;
import com.kafka.musicplayer.model.MusicClass;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MusicDB {
    public static List<MusicClass> findall()throws SQLException{

        List<MusicClass> musicList = new ArrayList<>();

        try(Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/music_collections", "postgres", "asdfghjkl;'")){

            System.out.println("Connection successful");
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM musicDetails;";

            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData meta = rs.getMetaData();

            int columncount = meta.getColumnCount();

            while(rs.next()){
                System.out.println(rs.getString("title"));
            }

            MusicClass music = new MusicClass();
            music.setTitle(rs.getString("title"));
            music.setAlbum(rs.getString("album"));
            music.setArtist(rs.getString("artist"));
            music.setGenre(rs.getString("genreA"));
            music.setRelease_year(rs.getString("release_year"));
            music.setDuration(rs.getString("duration"));
            musicList.add(music);

        }catch (SQLException e){
            System.out.println("Connection Failed " + e.getMessage());
        }
        return musicList;

    }
    public static void Insert(String title, String artist, String album, String genre, String release_year, String duration)throws SQLException{
        String username = "postgres";
        String password = "asdfghjkl;'";
        String url = "jdbc:postgresql://localhost:5432/music_collections";

        try(Connection conn = DriverManager.getConnection(url, username, password)){
            String[] durationParts = duration.split(":");
            int minutes = Integer.parseInt(durationParts[0]);
            int seconds = Integer.parseInt(durationParts[1]);

            duration = minutes + " minutes " + seconds + " seconds ";

            String query = "INSERT INTO musicDetails (title, artist, album, genre, release_year, duration) VALUES (?, ?, ?, ?, ?, ?::interval)" +
                    " ON CONFLICT (title) DO NOTHING;";

            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, title);
            pstmt.setString(2, artist);
            pstmt.setString(3, album);
            pstmt.setString(4, genre);
            pstmt.setString(5, release_year);
            pstmt.setString(6, duration);

            int rowsaffected = pstmt.executeUpdate();
            if(rowsaffected == 0){
                System.out.println("Duplicate music, nothing changed");
            }
            else{
                System.out.println("Insert Successful");
            }

        } catch (SQLException e){
            System.out.println("Connection Failed " + e.getMessage());
        }
    }

}
