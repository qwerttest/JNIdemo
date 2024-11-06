package com.jin.jnidemo.demo2;

public class JNIExample {
    // 加载名为 "nativeMethod" 的本地方法
    public native void nativeMethod(String str);

    // 静态代码块，加载名为 "libNativeLibrary.so" 的本地库
    static {
        System.loadLibrary("NativeLibrary");
    }
}
