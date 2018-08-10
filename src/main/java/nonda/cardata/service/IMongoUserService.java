package nonda.cardata.service;

import nonda.cardata.model.MongoUser;


import java.util.List;

public interface IMongoUserService {

    MongoUser insert(MongoUser mongoUser);

    List<MongoUser> findAll();


}
