package com.zyccx.jmm.query;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 获取 JVM 内存信息 示例
 */
public class QueryJVM {
    /**
     * main
     *
     * @param args args
     */
    public static void main(String[] args) {

        List<Map<String, String>> maps = generateMapList(100000L);
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage usage = memoryMXBean.getHeapMemoryUsage();
        System.out.printf("init heap: %s \n", getSize(usage.getInit()));
        System.out.printf("max heap: %s \n", getSize(usage.getMax()));
        System.out.printf("used heap: %s \n", getSize(usage.getUsed()));
        System.out.printf("committed heap: %s\n", getSize(usage.getCommitted()));

        System.out.println("\nFull Information:");
        System.out.printf("Heap Memory Usage: %s \n", usage);
        System.out.printf("Non-Heap Memory Usage: %s\n", memoryMXBean.getNonHeapMemoryUsage());

        List<String> jvmArgs = ManagementFactory.getRuntimeMXBean().getInputArguments();
        System.out.println("=====================jvm options==================");
        System.out.println(jvmArgs);


        System.out.println("=====================通过java来获取相关系统状态====================");
        long totalMemory = Runtime.getRuntime().totalMemory();
        long maxMemory = Runtime.getRuntime().maxMemory();
        long freeMemory = Runtime.getRuntime().freeMemory();

        System.out.printf("Total_Memory(-Xms )： %s\n", getSize(totalMemory));
        System.out.printf("Max_Memory(-Xmx )： %s\n", getSize(maxMemory));
        System.out.printf("freeMemory： %s\n\n", getSize(freeMemory));

        System.out.printf("maps size: %d \n\n",maps.size());
    }

    /**
     * getSize
     *
     * @param size size
     * @return
     */
    public static String getSize(Long size) {

        // GB
        Long GB = 1024 * 1024 * 1024L;
        // MB
        Long MB = 1024 * 1024L;
        // KB
        Long KB = 1024L;
        // 格式化小数
        DecimalFormat df = new DecimalFormat("0.00");
        String resultSize = "";
        if (size / GB >= 1) {
            resultSize = String.format("%sGB", df.format(size / (float) GB));
        } else if (size / MB >= 1) {
            resultSize = String.format("%sMB", df.format(size / (float) MB));
        } else if (size / KB >= 1) {
            resultSize = String.format("%sKB", df.format(size / (float) KB));
        } else {
            resultSize = String.format("%dB", size);
        }
        return resultSize;
    }

    /**
     * generateMapList
     *
     * @param size size
     * @return
     */
    private static List<Map<String, String>> generateMapList(Long size) {
        List<Map<String, String>> list = new ArrayList<>();
        for (Integer i = 0; i < size; i++) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("name", String.format("zhangSan-%d", i));
            map.put("age", "18");
            map.put("address", String.format("北京市海淀区上地五街七号1段一层，%d", i));
            list.add(map);
        }
        return list;
    }
}
