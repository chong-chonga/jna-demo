package app;

import demo.JnaService;
import structure.ParamStruct;
import structure.ResponseStruct;

/**
 * 在一些场景中，如离线计算占用资源会比较大、RPC调用不稳定等；C++作为更底层语言，在很多场景下，它的计算效率是比较高的。
 * 如果能将这些修改本地化调用，那么也能使程序本身受益，因此本项目探索了Java跨语言调用本地C库的使用。
 * Java提供了JNI和JNA两种调用C语言代码的方式，本项目采用JNA方式。
 * 跨语言调用有开销，JVM需要在本地方法栈帧和JVM栈之间进行内存复制，另外，JVM的对象还包含meta数据，都需要进行封装和映射，
 * 因此使用本地化C库调用并不一定就会带来性能上的提升，只适合针对特定场景进行优化。
 * @author huanglexin
 * @version 1.0
 * @date 2023/10/10 10:30
 */
public class App {

	public static void main(String[] args) {
		JnaService jna = new JnaService();
		jna.printApiExample("/api/demo", "do Something", "response ok");
		ParamStruct paramStruct = new ParamStruct();
		paramStruct.setF1(1);
		paramStruct.setF2(2);
		ResponseStruct response = jna.calculate(paramStruct);
		System.out.println(response);
	}
}
