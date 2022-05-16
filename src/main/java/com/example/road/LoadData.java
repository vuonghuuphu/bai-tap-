package com.example.road;

import com.example.road.district.District;
import com.example.road.district.DistrictRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class LoadData {
    @Component
    public class loaddata implements CommandLineRunner {
        @Autowired
        DistrictRepository districtRepository;
        @Override
        public void run(String... args) throws Exception{
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
}
