package com.example.demo1.service;

import com.example.demo1.entity.Settings;
import com.example.demo1.repository.ISettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SettingsService implements ISettingsService {
    @Autowired
    private ISettingsRepository settingsRepository;
    @Override
    public Settings getSettings() {
        return settingsRepository.getSettings();
    }

    @Override
    public void update(Settings settings) {
        settingsRepository.update(settings);
    }
}
