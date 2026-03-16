package com.example.demo1.service;

import com.example.demo1.entity.Settings;

public interface ISettingsService {
    Settings getSettings();
    void update(Settings settings);
}
