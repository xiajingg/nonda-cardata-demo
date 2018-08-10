package nonda.cardata.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Data
@Document(collection = "_User")
public class MongoUser {
    @Id
    private String _id;
    private String _session_token;
    private String _hashed_password;
    private String _perishable_token;
//    @DBRef
//    private List<AuthDataFacebook> _auth_data_facebook;
    private String _created_at;
    private String _updated_at;
    private String username;
    private String emailVerified;
    private String registerFrom;
    private String email;
    private String firstName;
    private String _email_verify_token;
    private String config;


}
