package structure;

import com.sun.jna.Structure;

/**
 * 参数结构体
 * 类必须使用{@link com.sun.jna.Structure.FieldOrder} 注解指定字段的顺序，字段必须使用public修饰且名称必须和C结构体保持一致
 * 类的字段数量最好和C结构体的字段保持一致，否则可能会出现诸如内存泄漏等奇怪的问题
 * @author huanglexin
 * @version 1.0
 * @date 2023/10/10 14:51
 */
@Structure.FieldOrder({"f1", "f2"})
public class ParamStruct extends Structure {

   public int f1;

   public int f2;

   public ParamStruct() {
      super();
   }

   public int getF1() {
      return f1;
   }

   public void setF1(int f1) {
      this.f1 = f1;
   }

   public int getF2() {
      return f2;
   }

   public void setF2(int f2) {
      this.f2 = f2;
   }
}
