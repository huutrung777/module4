package com.example.song.service;

import com.example.song.dto.SongDto;
import com.example.song.entity.Song;
import com.example.song.repository.ISongRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepository songRepository;
    @Override
    public void save(SongDto songDto) {
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        songRepository.save(song);
    }

    @Override
    public SongDto findById(int id) {
        Song song = songRepository.findById(id).orElse(null);
        if (song != null) {
            SongDto songDto = new SongDto();
            BeanUtils.copyProperties(song, songDto);
            return songDto;
        }
        return null;
    }

    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }
}