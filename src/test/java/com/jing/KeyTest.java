package com.jing;

import nonda.cardata.DemoApplication;
import nonda.cardata.util.cypher.CypherHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.KeyPair;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = DemoApplication.class)
public class KeyTest {

    @Test
    public void a1(){
        KeyPair keyPair =CypherHelper.generateKeyPair();
        System.out.println("pri:"+keyPair.getPrivate());
        System.out.println("pub:"+keyPair.getPublic());
    }
}
