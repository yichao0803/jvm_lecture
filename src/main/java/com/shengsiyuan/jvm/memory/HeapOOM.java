package com.shengsiyuan.jvm.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname HeapOOM
 * @Description
 * VM Args：-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @Date 2019/9/3 15:15
 * @Created by Zhangyichao
 */
public class HeapOOM {
    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list =new ArrayList<OOMObject>();
        do{
            list.add(new OOMObject());
        }
        while (true);

//         List<Map<String,OOMObject>> list = new ArrayList< Map<String,OOMObject>>();
//
//        do {
//            // list.add(new OOMObject());
//            Map<String,OOMObject> m = new HashMap<String,OOMObject>();
//            list.add(m);
//        } while (true);
    }
}
