#include "com_jin_jnidemo_demo_NativeCrashHandler.h"
#include <signal.h>
#include <jni.h>
#include <stdlib.h>
#include <android/log.h>
#include <unistd.h>
#include <stdio.h>

// 信号处理函数
void handle_sigsegv(int signal) {
    // 处理SIGSEGV
    __android_log_print(ANDROID_LOG_ERROR, "NativeCrashHandler", "Caught SIGSEGV signal =%d", signal);
    // 进行必要的崩溃处理，比如保存日志、崩溃报告等
}

void handle_sigbus(int signal) {
    // 处理SIGBUS
    __android_log_print(ANDROID_LOG_ERROR, "NativeCrashHandler", "Caught SIGBUS signal =%d", signal);
    // 进行必要的崩溃处理，比如保存日志、崩溃报告等
}

// 注册信号处理函数
registerSignalHandlers() {
    // 注册SIGSEGV处理函数
    struct sigaction sa;
    sa.sa_flags = SA_ONSTACK;
    sa.sa_handler = &handle_sigsegv;
    sigemptyset(&sa.sa_mask);
    sigaction(SIGSEGV, &sa, NULL);

    // 注册SIGBUS处理函数
    sa.sa_handler = &handle_sigbus;
    sigaction(SIGBUS, &sa, NULL);
    __android_log_print(ANDROID_LOG_DEBUG, "NativeCrashHandler", "registerSignalHandlers Success");
}

JNIEXPORT void JNICALL
Java_com_jin_jnidemo_demo_NativeCrashHandler_nativeInit(JNIEnv *env, jclass clazz) {
    registerSignalHandlers();
}