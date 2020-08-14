export GOARCH=arm
export GOOS=android
export CGO_ENABLED=1
export CC=/Users/jinglongcai/sdk/android/sdk/ndk/20.0.5594570/toolchains/llvm/prebuilt/darwin-x86_64/bin/armv7a-linux-androideabi21-clang
go build -buildmode=c-shared -o output/android/armeabi-v7a/libadd.so add_library.go

export GOARCH=arm64
export GOOS=android
export CGO_ENABLED=1
export CC=/Users/jinglongcai/sdk/android/sdk/ndk/20.0.5594570/toolchains/llvm/prebuilt/darwin-x86_64/bin/aarch64-linux-android21-clang
go build -buildmode=c-shared -o output/android/arm64-v8a/libadd.so add_library.go