package com.example.demo1.repository;

import com.example.demo1.entity.Settings;
import org.springframework.stereotype.Repository;

@Repository
public class SettingsRepository implements ISettingsRepository {

    private Settings settings =
            new Settings("English",25,true,"Thor\nKing, Asgard");

    @Override
    public Settings getSettings() {
        return settings;
    }

    @Override
    public void update(Settings settings) {
        this.settings = settings;
    }
}
