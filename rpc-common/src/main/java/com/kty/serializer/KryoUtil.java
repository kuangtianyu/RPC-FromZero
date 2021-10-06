package com.kty.serializer;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Kryo.DefaultInstantiatorStrategy;
import com.esotericsoftware.kryo.Registration;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
 
import org.objenesis.strategy.StdInstantiatorStrategy;
 
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
 
/**
 * @author kty
 * @since
 */
public class KryoUtil {
  public static Kryo kryo;
  private static Map<Class<?>, Registration> cachedSchema = new ConcurrentHashMap();
 
  static {
    kryo = new Kryo();
    kryo.setInstantiatorStrategy(new DefaultInstantiatorStrategy(new StdInstantiatorStrategy()));
  }
 
  @SuppressWarnings("unchecked")
  private static Registration getRegistration(Class cls) {
    Registration registration = cachedSchema.get(cls);
    if (registration == null) {
      synchronized (KryoUtil.class) {
        registration = kryo.register(cls);
        if (registration != null) {
          cachedSchema.put(cls, registration);
        }
      }
    }
    return registration;
  }
 
 
  /**
   * 序列化（对象 -> 字节数组）
   */
  public synchronized static <T> byte[] serialize(T obj) {
    Output output = new Output(1, 4096);
    kryo.writeObject(output, obj);
    output.flush();
    return output.toBytes();
  }
 
  /**
   * 反序列化（字节数组 -> 对象）
   */
  public synchronized static <T> T deserialize(byte[] data, Class<T> cls) {
    Input input = new Input(data);
    T s = (T) kryo.readObject(input, getRegistration(cls).getType());
    input.close();
    return s;
  }
}