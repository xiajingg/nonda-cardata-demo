package nonda.cardata.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@Document(collection = "VoltageFullData")
public class MongoVoltageDto {

    @Id
    @Field(value = "_id")
    private String id;
    @Field(value = "_p_user")
    private String pUser;
    @Field(value = "_p_vehicle")
    private String pVehicle;
    @Field(value = "_created_at")
    private Date createdAt;
    @Field(value = "_updated_at")
    private Date updatedAt;
    @Field(value = "time")
    private long time;
    @Field(value = "data")
    private Object data;
}
