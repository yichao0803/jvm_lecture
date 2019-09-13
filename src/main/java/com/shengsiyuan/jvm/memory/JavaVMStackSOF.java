package com.shengsiyuan.jvm.memory;

/**
 * @Classname JavaVMStackSOF
 * @Description
 * VM Args：-Xss128k
 * @Date 2019/9/4 22:13
 * @Created by Zhangyichao
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}