public class SingleObject
{
    private static SingleObject instance = new SingleObject();

    //私有化构造函数，这样该类就不会被实例化
    private SingleObject(){}

    //获取唯一可用的对象
    public static SingleObject getInstanece()
    {
        return instance;
    }

    public void showMessage()
    {
        System.out.println("Hello World!");
    }
}