package nonda.cardata.service.impl;

import nonda.cardata.model.User;
import nonda.cardata.model.dao.mysqlprimary.IUserDao;
import nonda.cardata.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xiajing on 2018/5/15.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao iUserDao;

    public List<User> findAll(){
        return iUserDao.findAll();
    }

    @Override
    public User save(User user) {
        return iUserDao.save(user);
    }

    public List<User> findByUsernameAndPassword(String username,String password){
        return iUserDao.findByUsernameAndPassword(username,password);
    }

}
