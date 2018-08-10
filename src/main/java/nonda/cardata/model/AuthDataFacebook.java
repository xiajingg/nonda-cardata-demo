package nonda.cardata.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

/**
 * 2018-05-21 18:25:59 by xiajing
 * user表关联的facebook账户信息
 */
@Data
@Document
public class AuthDataFacebook {

    @Id
    private String id;
    private String access_token;
    private String expiration_date;

    public AuthDataFacebook(String id, String access_token, String expiration_date) {
        this.id = id;
        this.access_token = access_token;
        this.expiration_date = expiration_date;
    }

    public AuthDataFacebook() {
    }
}
