package nonda.cardata.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
//@Entity
//@Component
//@Table(name = "tire_data")
public class TireDatam {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "tire_id")
    private String tireId;

    @Column(name = "time_division")
    private String time_division;

    @Column(name = "temperature")
    private String temperature;

    @Column(name = "pressure")
    private double pressure;

    @Column(name = "is_leak")
    private String isLeak;

    @Column(name = "is_lost")
    private String isLost;

    @Column(name = "low_battery")
    private String lowBattery;
}
