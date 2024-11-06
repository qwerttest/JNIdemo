package com.jin.jnidemo.demo;

public class NativeCrashHandler {

    static {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            // 从Android O开始，不能在static块中直接注册信号处理函数
//            System.loadLibrary("native-crash-handler");
//        } else {
//            // 在这个区间内，可以在static块中注册信号处理函数
//            registerSignalHandlers();
//        }
        System.loadLibrary("native-crash-handler");
    }

    // 注册信号处理函数的本地方法
    private static native void registerSignalHandlers();

    // 处理SIGSEGV和SIGBUS的信号回调
    private static void handleNativeCrash(int signal) {
        // 这里处理native崩溃，比如打印堆栈跟踪等
        // 注意：这里的代码必须是线程安全的，因为它可能在任何线程中调用
    }

    // 加载本地库，并注册信号处理函数
    public static void init() {
//        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
//            // 在Android O及以上版本，不能在static块中注册信号处理函数
//            registerSignalHandlers();
//        }
        nativeInit();
    }

    // 本地方法的JNI注册
    public static native void nativeInit();
}