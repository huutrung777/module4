package com.example.demo1.repository;

import com.example.demo1.entity.Settings;

public interface ISettingsRepository {
    Settings getSettings();
    void update(Settings settings);
}
