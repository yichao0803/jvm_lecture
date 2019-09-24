package com.shengsiyuan.jvm.gc;

/**
 * @Classname GcMemoryAllot
 * @Description
 * GC内存分配测试
 * <p>
 * 输出GC详细情况，初始堆大小,最大堆,年经代，打印GC日志,新生代Ende区与sruvivor(幸存者)区的比例8:1
 * <p>
 * VM arguments:
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * <p>
 * -XX:+UseSerialGC 使用Serial+Serial Old的收集器组合进行内存回收
 *
 * @Date 2019/9/16 23:17
 * @Created by Zhangyichao
 */
public class GcMemoryAllot {

    public static final int int_1MB = 1024 * 1024;

    public static void test1() {
        byte[] b_2M_1, b_2M_2, b_2M_3, b_4M_4;

        //对象优选在Ende园分配
        b_2M_1 = new byte[2 * int_1MB];
        b_2M_2 = new byte[2 * int_1MB];
        b_2M_3 = new byte[2 * int_1MB];
        // byte[] b_2M_add = new byte[2 * int_1MB];
        b_4M_4 = new byte[4 * int_1MB];// Ende园放不下了，出现一次 minorGC 新生代回收
    }

    public static void main(String[] args) {
        test1();
    }
}

/**
 * -XX:+UseSerialGC output>>  <p>
 [GC[DefNew: 6988K->479K(9216K), 0.0038915 secs] 6988K->6623K(19456K), 0.0039299 secs] [Times: user=0.02 sys=0.00, real=0.00 secs]
 Heap <p>
 def new generation   total 9216K, used 4905K [0x00000000f9a00000, 0x00000000fa400000, 0x00000000fa400000)
 eden space 8192K,  54% used [0x00000000f9a00000, 0x00000000f9e527b0, 0x00000000fa200000)
 from space 1024K,  46% used [0x00000000fa300000, 0x00000000fa377f80, 0x00000000fa400000)
 to   space 1024K,   0% used [0x00000000fa200000, 0x00000000fa200000, 0x00000000fa300000)
 tenured generation   total 10240K, used 6144K [0x00000000fa400000, 0x00000000fae00000, 0x00000000fae00000)
 the space 10240K,  60% used [0x00000000fa400000, 0x00000000faa00030, 0x00000000faa00200, 0x00000000fae00000)
 compacting perm gen  total 21248K, used 2541K [0x00000000fae00000, 0x00000000fc2c0000, 0x0000000100000000)
 the space 21248K,  11% used [0x00000000fae00000, 0x00000000fb07b4f0, 0x00000000fb07b600, 0x00000000fc2c0000)
 No shared spaces configured.
 *
 * @desc [GC[DefNew: 6988K->479K(9216K), 0.0038915 secs] 6988K->6623K(19456K),
 *       0.0039299 secs] [Times: user=0.02 sys=0.00, real=0.00 secs] [GC和[Full
 *       GC: 是指垃圾收集停顿类型
 *       <p>
 *       DefNew: DefNew（default new generation） Tenured Perm 表示GC发生的区域
 *       <p>
 *       6988K->479K(9216K): GC前该内存区域已使用容量->GC后该内存区域已使用的容量(该内存区域总容量)
 *       <p>
 *       988K->6623K(19456K):GC前JAVA堆已使用容量->GC后JAVA堆已使用的容量(JAVA堆总容量)
 *       <p>
 *       [Times: user=0.02 sys=0.00, real=0.00 secs] :
 *       GC所占用的时间 单位秒  用户态消耗的CPU时间 ,内核态消耗CPI事件 , 操作从开始到结束所经过墙钟的时间
 *       <p>
 *       堆内存情况:
 *       new generation: 新生代<p>
 *        total 9216K, used 4905K :总内存为9MB(10-)，已用4.79MB
 *       tenured generation:年老代<p>
 *       total 10240K, used 6144K:总空间10MB ,已用6MB
 *       compacting perm gen:持久代<p>
 *       total 21248K, used 2541K :20.75MB,已用 2.48MB
 *
 *
 */