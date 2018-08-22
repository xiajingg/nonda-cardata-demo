//package nonda.cardata.service.impl;
//
//import nonda.cardata.model.TireDataMongo;
//import nonda.cardata.model.dao.ITireDataMongoDao;
//import nonda.cardata.service.ICarDataMongoService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
////import nonda.cardata.collector.dao.mapper.mongo.IUserMongoDao;
//
///**
// * 2018-05-21 13:24:15 xiajing
// * 用于查询mongo数据库的 胎压 电压 行程 停车的数据
// */
//@Service
//public class CarDataMongoServiceImpl implements ICarDataMongoService {
//
////    @Autowired
////    private IUserMongoDao iUserMongoDao;
//
//    @Autowired
//    private ITireDataMongoDao iTireDataMongoDao;
//
////    //查询全部停车记录数据
////    @Override
////    public List<ParkingMongo> findParkingMongoAll() {
////        return iUserMongoDao.findParkingMongoAll();
////    }
////
//    //查询全部行程数据
//    @Override
//    public List<TireDataMongo> findTireDataMongoAll() {
//        return iTireDataMongoDao.findAll();
//    }
//
//    @Override
//    public Page<TireDataMongo> findOne(int pageNo,int pagesize) {
//        Pageable pageable=new PageRequest(pageNo, pagesize);
//        return iTireDataMongoDao.findAll(pageable);
//    }
////
////    @Override
////    public List<TirpMongo> findTirpMongoAll() {
////        return iUserMongoDao.findTirpMongoAll();
////    }
//
////    @Override
////    public List<UserMongo> findUserMongo() {
////        return iUserMongoDao.findAll();
////    }
//
////    @Override
////    public List<VehicleMongo> findVehicleMongo() {
////        return iUserMongoDao.findVehicleMongo();
////    }
////
////    @Override
////    public List<VoltageMongo> findVoltageMongo() {
////        return iUserMongoDao.findVoltageMongo();
////    }
//}
