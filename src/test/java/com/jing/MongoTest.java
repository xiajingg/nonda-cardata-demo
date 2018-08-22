package com.jing;

import nonda.cardata.DemoApplication;
import nonda.cardata.model.MongoVoltageDto;
import nonda.cardata.service.IMongoVoltageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class MongoTest {

    @Autowired
    private IMongoVoltageService iMongoVoltageService;

    @Test
    public void findAll()throws Exception{
        List<MongoVoltageDto> voltageDtos=iMongoVoltageService.findPrimaryAll(1,10).getContent();
        for (MongoVoltageDto mongoVoltageDto:voltageDtos){
            System.out.print(mongoVoltageDto.getId()+"==>1:"+mongoVoltageDto.getCreatedAt()+"==>"+mongoVoltageDto.getTime());
            System.out.println();
        }

        List<MongoVoltageDto> voltage2Dtos=iMongoVoltageService.findSecondaryAll(1,10).getContent();
        for (MongoVoltageDto mongoVoltageDto:voltage2Dtos){
            System.out.print(mongoVoltageDto.getId()+"==>2:"+mongoVoltageDto.getCreatedAt()+"==>"+mongoVoltageDto.getTime());
            System.out.println();
        }
    }

    @Test
    public void fingtime(){
        Calendar calendar=Calendar.getInstance();
        Date end=calendar.getTime();
        calendar.add(Calendar.MINUTE,-600);
        Date start=calendar.getTime();
        List<MongoVoltageDto> mongoVoltageDtos=iMongoVoltageService.findByUpdatedAtBetween(start,end);
        for (MongoVoltageDto vo:mongoVoltageDtos){
            System.out.println(vo.getId()+":"+vo.getPUser()+":"+vo.getPVehicle()+":"+vo.getData()+":"+vo.getUpdatedAt()+"==>"+vo.getCreatedAt());
        }
    }
}

