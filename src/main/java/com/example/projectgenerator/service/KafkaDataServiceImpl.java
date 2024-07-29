package com.example.projectgenerator.service;

import com.example.projectgenerator.model.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.kafka.sender.KafkaSender;
import reactor.kafka.sender.SenderRecord;

@Service
@RequiredArgsConstructor
public class KafkaDataServiceImpl implements KafkaDataService {

    private final KafkaSender<String, Object> sender;

    @Override
    public void send(Data data) {
        String topic = switch (data.getMeasurementType()) {
            case POWER -> "data-power";
            case VOLTAGE -> "data-voltage";
            case TEMPERATURE -> "data-temperature";
        };
        sender.send(
                        Mono.just(
                                SenderRecord.create(
                                        topic,
                                        0,
                                        System.currentTimeMillis(),
                                        String.valueOf(data.hashCode()),
                                        data,
                                        null
                                )
                        )
                )
                .subscribe();
    }

}
