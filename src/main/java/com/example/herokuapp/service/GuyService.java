package com.example.herokuapp.service;

import com.example.herokuapp.entity.Guy;

public interface GuyService {
    void save(Guy guy);

    Guy getGayGuy();
}
