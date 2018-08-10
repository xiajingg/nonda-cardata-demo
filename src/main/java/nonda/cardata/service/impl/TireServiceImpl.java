package nonda.cardata.service.impl;

import nonda.cardata.model.Tire;
import nonda.cardata.model.dao.ITireDao;
import nonda.cardata.service.ITireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TireServiceImpl implements ITireService {


    @Autowired
    private ITireDao iTireDao;


    @Override
    public Tire save(Tire tire){
        return iTireDao.save(tire);
    }

}
