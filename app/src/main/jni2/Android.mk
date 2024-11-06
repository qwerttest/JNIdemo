LOCAL_PATH := $(call my-dir)	# 获取当前路径，并保存在LOCAL_PATH中

NDK_PROJECT_PATH := $(call my-dir)	# 获取当前路径，并保存在NDK_PROJECT_PATH中
include $(CLEAR_VARS)		# 由编译系统提供，GNU MAKEFILE清除LOCAL_XXX变量，除了LOCAL_PATH以外
LOCAL_MODULE := NativeLibrary	# 指定编译出的库名
LOCAL_SRC_FILES := Hello.c	# 指定编译源文件
LOCAL_LDLIBS := -llog    # 指定编译时链接的库，-llog表示链接liblog.so库
include $(BUILD_SHARED_LIBRARY) # 指定编译成动态链接库，BUILD_STATIC_LIBRARY为静态库