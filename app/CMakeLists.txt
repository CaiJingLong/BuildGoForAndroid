cmake_minimum_required(VERSION 3.10.2)

project(android_lib)

set(GO_BUILD_PATH ${CMAKE_CURRENT_SOURCE_DIR}/../go/output/android)
set(SRC ${GO_BUILD_PATH}/${CMAKE_ANDROID_ARCH_ABI})

include_directories(${SRC})

find_library(
        std-lib
        android
)

message("CPU ABI: ${CMAKE_ANDROID_ARCH_ABI}")

if (${CMAKE_ANDROID_ARCH_ABI} EQUAL "armeabi") ## 根据ABI的不同, 复制so文件到对应的文件夹
    file(COPY ${GO_BUILD_PATH}/${CMAKE_ANDROID_ARCH_ABI}/libadd.so DESTINATION ${CMAKE_CURRENT_SOURCE_DIR}/libs/${CMAKE_ANDROID_ARCH_ABI}) # 复制库文件
else ()
    file(COPY ${SRC}/libadd.so DESTINATION ${CMAKE_CURRENT_SOURCE_DIR}/libs/${CMAKE_ANDROID_ARCH_ABI}) # 复制库文件
endif ()
file(COPY ${SRC}/libadd.h DESTINATION ${CMAKE_CURRENT_SOURCE_DIR}/src/main/jni) # 复制头文件

file(GLOB JNI_SRC ${CMAKE_CURRENT_SOURCE_DIR}/src/main/jni/*.c ${CMAKE_CURRENT_SOURCE_DIR}/src/main/jni/*.h) # 扫描jni目录下的头文件和库文件, 并设置给JNI_SRC
add_library(my_jni SHARED ${JNI_SRC}) # 添加jni中转库

file(GLOB OUTPUT_LIBRARY libs/${CMAKE_ANDROID_ARCH_ABI}/*.so) # 找到对应cpu的so库文件

target_link_libraries(
        my_jni
        ${std-lib} # 连接android标准库给jni, 因为golang用到了一些标准库的定义
        ${OUTPUT_LIBRARY} # 连接给jni库
)