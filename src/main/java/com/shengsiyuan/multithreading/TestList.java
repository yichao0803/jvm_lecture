package com.shengsiyuan.multithreading;

import org.apache.log4j.Logger;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author by Zhangyichao
 * @date 2019/11/4 14:38
 * @see TestList
 */
public class TestList {
    private static Logger logger =Logger.getLogger(TestList.class);
    public static void main(String[] args) {
        List<TestA> listAS=new ArrayList<>();
        TestA testA=new TestA();
        listAS.add(testA);
        testA.setId(1);
        testA.setName("张三");
        listAS.add(testA);
        testA.setId(2);
        testA.setName("李四");

        for (TestA testA1:listAS){
            logger.info(MessageFormat.format("id：{0}，name：{1}",
                    testA1.getId(),testA1.getName()));
        }
    }
}

class TestA {

    private String name;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
