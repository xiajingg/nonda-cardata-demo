package nonda.cardata.model;

import com.mongodb.util.JSON;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;

@Document(collection = "Vehicle")
@Data
public class Vehilce {
    @Id
    private String _id;

//    private String name;



    @Override
    public String toString() {
        return JSON.serialize(this);
    }
}
