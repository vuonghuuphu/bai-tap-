package com.example.road;

import com.example.road.district.District;
import com.example.road.district.DistrictRepository;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class RoadApplicationTests {
    @Autowired
    DistrictRepository districtRepository;
    @Test
    void contextLoads() {
        Faker faker = new Faker();
        districtRepository.deleteAll();
        List<District> l = new ArrayList<>();
        for (int i = 1;i<100;i++){
            l.add(new District(
                    i,
                    faker.name().title()
            ));
        }
        districtRepository.saveAll(l);
        System.out.println("Save all");
    }

}
