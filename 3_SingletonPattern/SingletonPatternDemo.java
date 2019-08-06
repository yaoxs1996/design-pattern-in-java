public class SingletonPatternDemo
{
    public static void main(String[] args)
    {
        //构造函数不可见
        //获取唯一可用的对象
        SingleObject object = SingleObject.getInstanece();

        object.showMessage();
    }
}