package nonda.cardata.model.dao;

import nonda.cardata.model.MongoUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IMongoUserDao extends MongoRepository<MongoUser,String>{

    MongoUser findByusername(String username);
}
