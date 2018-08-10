package nonda.cardata.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "reports")
public class Reports {

    @Id
    private String id;
    private String amazonOrderID;
    private String merchantOrderID;
    private String shipmentID;
    private String marketplaceName;
    private String merchantFulfillmentID;
    private String postedDate;
    private String settlementId;
    private String type;
    private String sku;
    private String quantity;
    //    private String orderCity;
//    private String orderState;
//    private String orderPostal;
    private double principal;//成本
    private double itemPriceShipping;//免运费(如果面运费, 这边会先给你一笔运费, 然后后面会扣掉运费,相当于不多不少)
    private double fbaPerUnitFulfillmentFee;//不知道什么服务费
    private double fbaWeightBasedFee;//物流配送费
    private double commission;//佣金
    private double Shipping;//运费
    private double fbaFees;
    private double otherTransactionFees;
    private double other;

}
