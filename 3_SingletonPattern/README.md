# 单例模式

该类负责创建自己的对象，同时确保只有单个对象被创建，提供访问该对象的唯一方式，不需要实例化对象。

## 几种实现方式

### 懒汉式，线程不安全（不建议）

```java
public class Singleton
{
    private static Singleton instance;
    private Singleton(){}

    public static Singleton getInstance()
    {
        if(instance == null)
        {
            instance = new Singleton();
        }
        return instance;
    }
}
```

Lazy初始化，多线程不安全，易实现。  

### 懒汉式，线程安全（不建议）

```java
public class Singleton
{
    private static Singleton instance;
    private Singleton(){}
    public static synchronized Singleton getInstance()
    {
        if(instance == null)
        {
            instance = new Singleton();
        }
        return instance;
    }
}
```

Lazy初始化，多线程安全，易于实现。

### 饿汉式（建议）

```java
public class Singleton
{
    private static Singleton instance = new Singleton();
    private Singleton(){}
    public static Singleton getInstance()
    {
        return instance;
    }
}
```

非Lazy初始化，多线程安全，易实现。

### 双检锁

```java
public class Singleton
{
    private volatile static Singleton singleton;
    private Singleton(){}
    public static Singleton getSingleton()
    {
        if(singleton == null)
        {
            synchronized (Singleton.class)
            {
                if(singleton == null)
                {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
```

Lazy初始化，多线程安全，实现较复杂。

### 登记式/静态内部类

```java
public class Singleton
{
    private static class SingletonHolder
    {
        private static final Singleton INSTANCE = new Singleton();
    }
    private Singleton(){}
    public static final Singleton getInstance()
    {
        return SingletonHolder.INSTANCE;
    }
}
```

Lazy初始化，多线程安全，实现难度一般。

### 枚举（涉及反序列化创建对象时）

```java
public enum Singleton
{
    INSTANCE;
    public void whateverMethod(){

    }
}
```

不是Lazy初始化，多线程安全，易实现。
