package com.example.projectgenerator.service;

import com.example.projectgenerator.model.Data;

public interface KafkaDataService {

    void send(Data data);

}
