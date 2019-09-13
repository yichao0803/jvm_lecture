package com.shengsiyuan.jvm.memory;

/**
 * @Classname JavaVMStackOOM
 * @Description -Xss2M （这时候不妨设大些）
 * @Date 2019/9/4 22:17
 * @Created by Zhangyichao
 */

public class JavaVMStackOOM {

    private void dontStop() {
        do {
        } while (true);
    }

    public void stackLeakByThread() {
        do {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        } while (true);
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}

