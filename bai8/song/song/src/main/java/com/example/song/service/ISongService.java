package com.example.song.service;

import com.example.song.dto.SongDto;
import com.example.song.entity.Song;
import java.util.List;

public interface ISongService {
    void save(SongDto songDto);
    SongDto findById(int id);
    List<Song> findAll();
}