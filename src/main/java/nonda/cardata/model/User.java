package nonda.cardata.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Map;

/**
 * Created by xiajing on 2018/4/16.
 */
//注入为bean
@Component
//找配置文件里的属性值
//@ConfigurationProperties(prefix = "girl")
@Data
@Entity(name="user")
public class User {

    @Id
    private String _id;
//    private String _session_token;
//    private String _hashed_password;
//    private String _perishable_token;
//    //    @DBRef
////    private List<AuthDataFacebook> _auth_data_facebook;
//    private String _created_at;
//    private String _updated_at;
    private String username;
    private Double nu;
//    private String emailVerified;
//    private String registerFrom;
//    private String email;
//    private String firstName;
//    private String _email_verify_token;
//    private String config;

//    public User(String _id, String _session_token, String _hashed_password, String _perishable_token, String _created_at, String _updated_at, String username, String emailVerified, String registerFrom, String email, String firstName, String _email_verify_token, String config) {
//        this._id = _id;
//        this._session_token = _session_token;
//        this._hashed_password = _hashed_password;
//        this._perishable_token = _perishable_token;
//        this._created_at = _created_at;
//        this._updated_at = _updated_at;
//        this.username = username;
//        this.emailVerified = emailVerified;
//        this.registerFrom = registerFrom;
//        this.email = email;
//        this.firstName = firstName;
//        this._email_verify_token = _email_verify_token;
//        this.config = config;
//    }

    public User() {
    }

    public User(String _id, String username, Double nu) {
        this._id = _id;
        this.username = username;
        this.nu = nu;
    }
}
