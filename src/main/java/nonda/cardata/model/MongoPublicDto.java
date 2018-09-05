package nonda.cardata.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
public class MongoPublicDto {
    @Field(value = "_created_at")
    private Date createdAt;
    @Field(value = "_updated_at")
    private Date updatedAt;
}
