package nonda.cardata.model.dao.primary;

import nonda.cardata.model.MongoVoltageDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

public interface IMongoVoltagePrimaryDao extends MongoRepository<MongoVoltageDto,String> {

    //根据创建时间查询
    List<MongoVoltageDto> findByUpdatedAtBetween(Date start, Date end);
}
