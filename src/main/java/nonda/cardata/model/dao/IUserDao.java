package nonda.cardata.model.dao;

import nonda.cardata.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by xiajing on 2018/5/15.
 */
public interface IUserDao extends JpaRepository<User,Integer> {

    List<User> findByUsername(String username);

}
