package structure;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

/**
 * 响应结构体
 * 类必须使用{@link com.sun.jna.Structure.FieldOrder} 注解指定字段的顺序，字段必须使用public修饰且名称必须和C结构体保持一致
 * 类的字段数量最好和C结构体的字段保持一致，否则可能会出现诸如内存泄漏等奇怪的问题
 * 当C库函数返回值是结构体指针时, 此类必须声明一个接受{@link Pointer} 类型参数的构造方法
 * @author huanglexin
 * @version 1.0
 * @date 2023/10/10 14:51
 */
@Structure.FieldOrder("res")
public class ResponseStruct extends Structure {

   public Integer res;

	public ResponseStruct(Pointer pointer) {
		super(pointer);
		read();
	}

	@Override
	public String toString() {
		return "ResponseStruct{" +
				"res=" + res +
				'}';
	}
}
