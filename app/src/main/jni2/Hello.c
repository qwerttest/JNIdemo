#include <com_jin_jnidemo_demo2_JNIExample.h>
#include <android/log.h>
#include <string.h>
#include <pthread.h>
#include <jni.h>

JNIEXPORT void JNICALL Java_com_jin_jnidemo_demo2_JNIExample_nativeMethod(JNIEnv *env, jobject thiz, jstring str) {
    pthread_t currentThreadID = pthread_self();
    __android_log_print(ANDROID_LOG_INFO, "MyTag", "This is a log message start  currentThreadID == %d", currentThreadID);
    const char *nativeString = (*env)->GetStringUTFChars(env, str, 0);
    __android_log_print(ANDROID_LOG_INFO, "MyTag", "Received string: %s", nativeString);
    (*env)->ReleaseStringUTFChars(env, str, nativeString);
    __android_log_print(ANDROID_LOG_INFO, "MyTag", "This is a log message end");
}
