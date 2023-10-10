package demo;

import com.sun.jna.Native;
import localc.ObjectTypeLib;
import localc.PrimaryTypeLib;
import structure.ParamStruct;
import structure.ResponseStruct;

/**
 * @author huanglexin
 * @version 1.0
 * @date 2023/10/10 10:29
 */
public class JnaService {
   private PrimaryTypeLib primaryTypeLib;

   private ObjectTypeLib objectTypeLib;

   public JnaService() {
      // Java的实现里，加载动态库，最终调用的都是系统函数dlopen。
      // 这个函数在加载目标动态库时，会自动的加载它的间接依赖。resources目录下包含.so文件，就是为了将这些依赖放置到dlopen能够查找到路径下。
      // dlopen查找依赖的顺序如下：
      // 1. 从dlopen调用方ELF(Executable and Linkable Format)的DT_RPATH所指定的目录下寻找，ELF是so的文件格式，这里的DT_RPATH是写在动态库文件的，
      //    常规手段下，我们无法修改这个部分。
      // 2. 从环境变量LD_LIBRARY_PATH所指定的目录下寻找，这是最常用的指定动态库路径的方式。
      // 3. 从dlopen调用方ELF的DT_RUNPATH所指定的目录下寻找，同样是在so文件中指定的路径。
      // 4. 从/etc/ld.so.cache寻找，需要修改/etc/ld.so.conf文件构建的目标缓存，因为需要root权限，所以在实际生产中，一般很少修改。
      // 5. 从/lib寻找， 系统目录，一般存放系统依赖的动态库。
      // 6. 从/usr/lib寻找，通过root安装的动态库，同样因为需要root权限，生产中，很少使用。
      // 注: 使用JVM参数java.library.path可以指定动态库的位置

      // lib1.so
      primaryTypeLib = Native.load("1", PrimaryTypeLib.class);
      // libcalculate.so
      objectTypeLib = Native.load("calculate", ObjectTypeLib.class);
   }

   public void printApiExample(String url, String request, String response)
   {
      primaryTypeLib.print_api_example(url, request, response);
   }

   public ResponseStruct calculate(ParamStruct paramStruct) {
      return objectTypeLib.calculate(paramStruct);
   }
}
