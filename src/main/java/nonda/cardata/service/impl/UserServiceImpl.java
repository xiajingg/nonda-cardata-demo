package nonda.cardata.service.impl;

import nonda.cardata.model.User;
import nonda.cardata.model.dao.IUserDao;
import nonda.cardata.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xiajing on 2018/5/15.
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao iUserDao;

    public List<User> findAll(){
        return iUserDao.findAll();
    }

//    public User getOne(Integer id){
//        return iUserDao.findOne(id);
//    }

    public User createUser(User user){
        return iUserDao.save(user);
    }

    public int createUserList(List<User> users){
        for (int i=0;i<users.size();i++){
            iUserDao.save(users.get(i));
        }
        return 1;
    }

//    public void deleteUser(Integer id){
//        iUserDao.delete(id);
//
//    }

    public List<User> findByUsername(String username){
        return iUserDao.findByUsername(username);
    }

}
