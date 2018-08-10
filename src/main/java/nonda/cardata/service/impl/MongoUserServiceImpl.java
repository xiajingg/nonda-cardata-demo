package nonda.cardata.service.impl;

import nonda.cardata.model.dao.IMongoUserDao;
import nonda.cardata.model.MongoUser;
import nonda.cardata.service.IMongoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongoUserServiceImpl implements IMongoUserService {

    @Autowired
    private IMongoUserDao iMongoUserDao;



    @Override
    public MongoUser insert(MongoUser mongoUser){
        return iMongoUserDao.save(mongoUser);
    }

    @Override
    public List<MongoUser> findAll(){
        return iMongoUserDao.findAll();
    }

    public MongoUser findByusername(String username){
        return iMongoUserDao.findByusername(username);
    }

}
