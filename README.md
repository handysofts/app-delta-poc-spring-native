Read official docs: https://docs.spring.io/spring-native/docs/current/reference/htmlsingle/#getting-started

Download and unpack GraalVM
```shell
vim ~/.bashrc
export JAVA_HOME=~/graalvm/graalvm-ce-java11-21.2.0/
export PATH=${JAVA_HOME}/bin:$PATH
```

Install native-image to your GraalVM (https://www.graalvm.org/reference-manual/native-image/):
```shell
gu --jvm install native-image
```
If you have issue with certificate feel free to import `www.graalvm.org:443` to your `cacerts` file 
in `<PATH_TO_GRAALVM_DIR>\graalvm-ce-java11-21.2.0\lib\security`. You can use `kse` app for this


If you want to create native image on Windows then install Visual Studio 2019 and `build tools` from Individual Components (MSVC v142).
Additionally, you may need to download `Windows 10 SDK` from the same menu

Creating simple jar which we can use for standard image and deployment:
```shell
mvn clean package -DskipTests
```

Set your `JAVA_HOME` to point to your GraalVM installed dir

Create native image (on Windows execute below command from x64 Native Tools Command Prompt for VS2019):
```shell
mvn clean -Pnative -DskipTests package
```

You can run it using
```shell
./target/app-delta-poc-spring-native
```
Or

Create docker image from native image:
```shell
docker build -t app-delta-cloud .
```
Run it
```shell
docker run --rm -p 8082:8082 --name app-delta app-delta-cloud
```