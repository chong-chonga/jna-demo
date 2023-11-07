# jna-demo
在一些场景中，如离线计算占用资源会比较大、RPC调用不稳定等；C++作为更底层语言，在很多场景下，它的计算效率是比较高的。
如果能将这些修改本地化调用，那么也能使程序本身受益，因此本项目探索了Java跨语言调用本地C库的使用。
Java提供了JNI和JNA两种调用C语言代码的方式，本项目采用JNA方式。
跨语言调用有开销，JVM需要在本地方法栈帧和JVM栈之间进行内存复制，另外，JVM的对象还包含meta数据，都需要进行封装和映射，
因此使用本地化C库调用并不一定就会带来性能上的提升，只适合针对特定场景进行优化。

## Get Started

通过修改`print_api_example_wrapper.cpp`或`calculate_wrapper.cpp`这两个文件即可实现自定义的C++库。

在修改完成后，通过以下命令编译为动态链接库`libcalculate.so`，编译好的动态链接库推荐放置到**resources**目录下。


这里，使用源码依赖方式，将c_wrapper和C++代码一起编译生成.so文件。这种方式业务方只需要依赖一个so，使用成本较小，但是需要获取到源码。对于一些现成的动态库，可能不适用。
```shell
# calculate_wrapper.cpp单个文件即可
g++ -o lib1.so calculate_wrapper.cpp-fPIC -shared

# 编译print_api_example_wrapper.cpp
g++ -o libcalculate.so print_api_example_wrapper.cpp util.cpp -fPIC -shared
```
**注意：编译后的动态链接库可以自行修改，但必须是以lib开头的，不然Java的Native.load()方法将无法正确加载，且lib后的名称是作为Native.load方法的参数的**

### Java传递对象类型的参数
如果要实现Java传递对象类型的本地方法接口，可以通过修改`calculate_wrapper.cpp`文件。

### Java传递原生类型的参数
修改`print_api_example_wrapper.cpp`文件即可。