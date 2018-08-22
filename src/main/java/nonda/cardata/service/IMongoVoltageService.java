package nonda.cardata.service;

import nonda.cardata.model.MongoVoltageDto;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

public interface IMongoVoltageService {

    List<MongoVoltageDto> findByUpdatedAtBetween(Date start, Date end);

    Page<MongoVoltageDto> findPrimaryAll(int page, int rows);

    Page<MongoVoltageDto> findSecondaryAll(int page, int rows);
}
