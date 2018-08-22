package nonda.cardata.service.impl;

import nonda.cardata.model.MongoVoltageDto;
import nonda.cardata.model.dao.primary.IMongoVoltagePrimaryDao;
import nonda.cardata.model.dao.secondary.IMongoVoltageSecondaryDao;
import nonda.cardata.service.IMongoVoltageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MongoVoltageServiceImpl implements IMongoVoltageService {

    @Autowired
    private IMongoVoltagePrimaryDao iMongoVoltagePrimaryDao;

    @Autowired
    private IMongoVoltageSecondaryDao iMongoVoltageSecondaryDao;

    @Override
    public List<MongoVoltageDto> findByUpdatedAtBetween(Date start, Date end) {
        return iMongoVoltagePrimaryDao.findByUpdatedAtBetween(start,end);
    }



    @Override
    public Page<MongoVoltageDto> findPrimaryAll(int page, int rows) {
        PageRequest pageRequest = new PageRequest(page-1,rows, new Sort(Sort.Direction.DESC,"updatedAt"));
        return iMongoVoltagePrimaryDao.findAll(pageRequest);
    }

    @Override
    public Page<MongoVoltageDto> findSecondaryAll(int page, int rows) {
        PageRequest pageRequest = new PageRequest(page-1,rows, new Sort(Sort.Direction.DESC,"updatedAt"));
        return iMongoVoltageSecondaryDao.findAll(pageRequest);
    }
}
