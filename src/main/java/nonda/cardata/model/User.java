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
    private String id;
    private String username;
    private String password;
    @Column(name = "nick_name")
    private String nickName;

}
