package top.kikt.usegolibrary;

public class JniLibrary {

    static {
//        System.loadLibrary("add");
        System.loadLibrary("my_jni");
    }

    public static native int add(int x, int y);

    public static native int remove(int x, int y);

}
