package nonda.cardata.service;

import nonda.cardata.model.User;

import java.util.List;

/**
 * Created by xiajing on 2018/5/15.
 */
public interface IUserService {

     List<User> findAll();

     List<User> findByUsernameAndPassword(String username,String password);

     User save(User user);

}
