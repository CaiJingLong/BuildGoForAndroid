#include <jni.h>
#include "libadd.h"

//
// Created by jinglong cai on 2020/8/14.
//

JNIEXPORT jint JNICALL
Java_top_kikt_usegolibrary_JniLibrary_add(JNIEnv *env, jclass clazz, jint x, jint y) {
    return add(x, y);
//    return x + y;
}

JNIEXPORT jint JNICALL
Java_top_kikt_usegolibrary_JniLibrary_remove(JNIEnv *env, jclass clazz, jint x, jint y) {
    return remove_int(x, y);
}