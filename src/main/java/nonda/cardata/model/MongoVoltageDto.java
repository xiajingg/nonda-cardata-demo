package nonda.cardata.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@Document(collection = "VoltageFullData")
public class MongoVoltageDto extends MongoPublicDto {

    @Id
    @Field(value = "_id")
    private String id;
    @Field(value = "_p_user")
    private String pUser;
    @Field(value = "_p_vehicle")
    private String pVehicle;
    @Field(value = "time")
    private Long time;
    @Field(value = "data")
    private Object data;
}
