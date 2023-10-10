package localc;

import com.sun.jna.Library;
import structure.ParamStruct;
import structure.ResponseStruct;

/**
 * 本地C库的Java接口表达，参数全部使用原始类型
 * 可使用 {@code Native.load("$name$", ObjectTypeLib.class)} 创建本对象，JVM查找resources目录下名称为lib$name$.so的文件
 * 请注意动态链接文件名称和参数$name$的对应关系
 * 注意：方法的名称和C库暴露的函数名称需要保持一致，否则会出现 {@code Error looking up function } 异常
 * @author huanglexin
 * @version 1.0
 * @date 2023/10/10 15:33
 */
public interface ObjectTypeLib extends Library {

   /**
    * 测试本地库计算
    * @param param 计算参数
    * @return 计算结果
    */
   ResponseStruct calculate(ParamStruct param);
}
