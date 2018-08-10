package nonda.cardata.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "amazon_configuration")
public class AmazonConfiguration {

    @Id
    private String id;
    private String characterEncoding;
    private String algorithm;
    private String secretKey;
    private String serviceUrl;
    private String sellerId;
    private String mwsAuthToken;
    private String awsAccessKeyId;

}
