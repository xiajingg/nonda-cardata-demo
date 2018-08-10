package nonda.cardata.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

/**
 * 2018-05-21 14:02:34 by xiajing
 * mongo的胎压数据
 */
@Data
@Document(collection = "TireData")
public class TireDataMongo {

    @Id
    private String _id;
    private String _p_user;
    private String time;
    private String pos;
    private Object data;
    private String _p_vehicle;
    private Date _updated_at;
    private Date _created_at;

    /**
      示例数据

      {
          "_id": "XVRvIdkzU2",
          "_p_user": "_User$vLlCV5uWXT",
          "time": 1526774400000,
          "pos": "rr",
          "data": {
              "184": {
                  "t": 24,
                  "p": 227.04001,
                  "leak": 0,
                  "lost": 0,
                  "low_battery": 0
              },
              "185": {
                  "t": 24,
                  "p": 227.04001,
                  "leak": 0,
                  "lost": 0,
                  "low_battery": 0
              },
              "186": {
                  "t": 24,
                  "p": 227.04001,
                  "leak": 0,
                  "lost": 0,
                  "low_battery": 0
              }
          },
          "_p_vehicle": "Vehicle$XEPb4rhaoi",
          "_updated_at": {
              "$date": "2018-05-20T03:10:25.314Z"
          },
          "_created_at": {
              "$date": "2018-05-20T03:10:25.314Z"
          }
      }
     */

}
