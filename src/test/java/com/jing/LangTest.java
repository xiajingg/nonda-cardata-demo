package com.jing;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class LangTest {

    @Test
    public void a1(){
        System.out.println(StringUtils.substringAfter("Vehicle$sYYBftIgZr","$"));
    }
}
