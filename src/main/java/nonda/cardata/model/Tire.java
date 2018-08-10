package nonda.cardata.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 2018-05-21 14:19:05 by xiajing
 * 胎压数据
 */
@Component
@Data
@Entity
@Table(name = "tire")
public class Tire {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "user_id")
    private String pUser;

    @Column(name = "time_stamp")
    private String time;

    @Column(name = "tyre_pos")
    private String pos ="aa";

//    @Column(name = "tire_data_id")
//    private String dataId;

    @Column(name = "vehicle_id")
    private String pVehicle;

    @Column(name = "updated_time")
    private Date updatedTime;

    @Column(name = "created_time")
    private Date createdTime;
}
