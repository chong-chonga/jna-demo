//
// Created by lexin on 2023/10/10.
//

#include "util.h"

/*
 * 将C++实现封装为C语言模式的胶水代码
 * Python、Java只支持调用C语言接口，不支持调用C++，因此需要将函数的入参和出参修改为C语言支持的类型
 * 动态库中函数的寻址是通过dlsym来实现的，dlsym是按照传入的函数名来寻址的，Linux下的非静态函数以符号作为标识,而这个符号正是函数签名
 * 原因：在C语言中，函数签名即为代码函数的名称；C++为了支持重载，函数签名在编译后可能与原函数名称不一致
 * 注意：函数名称应当与Python、Java中加载的本地方法名称一致
 */
extern "C" {
    void print_api_example(const char* url, const char* request, const char* response) {
        Utils utils;
        std::string u = url;
        std::string req = request;
        std::string res = response;
        utils.printApiExample(u, req, res);
    }


}
