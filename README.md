# Build go library in android

Use the example

1. build go source to dynamic library

    ```shell
    cd go
    ./build_android_on_mac.sh # You must edit the shell, and set ANDROID_NDK_HOME to your ndk. The project use ndk version is 21.0.6113669, I just test macOS.
    ```

2. Run the app in Android Studio