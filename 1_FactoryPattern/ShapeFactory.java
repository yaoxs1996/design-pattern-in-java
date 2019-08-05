/* 创建工厂，生成基于给定信息的实体类的对象 */
public class ShapeFactory
{
    public Shape getShape(String shapeType)
    {
        if(shapeType == null)
        {
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE"))        //忽略大小写
        {
            return new Circle();
        }
        else if(shapeType.equalsIgnoreCase("RECTANGLE"))
        {
            return new Rectangle();
        }
        else if(shapeType.equalsIgnoreCase("SQUARE"))
        {
            return new Square();
        }
        return null;
    }
}