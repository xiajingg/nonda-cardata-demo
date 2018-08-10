package nonda.cardata.service.impl;

import nonda.cardata.model.TireDatam;
import nonda.cardata.model.dao.ITireDatamDao;
import nonda.cardata.service.ITireDatamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TireDatamServiceImpl implements ITireDatamService {

    @Autowired
    private ITireDatamDao iTireDatamDao;


    @Override
    public TireDatam save(TireDatam tireDatam) {
        return iTireDatamDao.save(tireDatam);
    }

}
