cd ./src/main/cpp

# 以源码方式编译动态库，可以根据需要进行修改
g++ -o libcalculate.so util.cpp calculate_wrapper.cpp -fPIC -shared

g++ -o lib1.so util.cpp print_api_example_wrapper.cpp -fPIC -shared

# 将动态库移至resources目录下
mv *.so ../resources
cd ../../../

# 打包jar文件
mvn clean install
