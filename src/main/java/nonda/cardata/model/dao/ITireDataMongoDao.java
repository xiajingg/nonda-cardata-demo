package nonda.cardata.model.dao;

import nonda.cardata.model.TireDataMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ITireDataMongoDao extends MongoRepository<TireDataMongo,String> {
}
