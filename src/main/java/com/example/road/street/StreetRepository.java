package com.example.road.street;

import com.example.road.district.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StreetRepository extends JpaRepository<Street,Integer> {
    @Query(value = "SELECT * FROM  streets a where a.district_id like %:key% or a.name like %:key%",nativeQuery = true)
    List<Street> search (@Param("key") String key);
}
