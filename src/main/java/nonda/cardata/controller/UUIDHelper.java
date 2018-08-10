package nonda.cardata.controller;

import java.util.UUID;

/*
 * 获取UUID算法 by tom 20180523
 */
public class UUIDHelper {
    private UUIDHelper(){

    }
    //获取32位的（字母大写）UUID
    public static String getUUID32(){
        String uuid = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        return uuid;
    }

}
