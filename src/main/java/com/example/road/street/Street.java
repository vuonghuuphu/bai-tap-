package com.example.road.street;

import com.example.road.district.District;
import com.example.road.status.StreetStatus;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "streets")
public class Street {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String name;
    private String description;
    private StreetStatus status;
    @ManyToOne
    @JoinColumn(name = "district_id")
    private District district;

}
