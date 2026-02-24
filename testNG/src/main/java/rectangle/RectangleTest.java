package rectangle;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RectangleTest {

    private Rectangle rectangle;

    @BeforeClass
    public void setup() {
        rectangle = new Rectangle();
    }

    @Test
    public void testCalculateAreaValid() {
        double area = rectangle.calculateArea(5, 3);
        Assert.assertEquals(area, 15.0);
    }

    @Test
    public void testCalculatePerimeterValid() {
        double perimeter = rectangle.calculatePerimeter(5, 3);
        Assert.assertEquals(perimeter, 16.0);
    }

    @Test
    public void testAreaWithDecimalValues() {
        double area = rectangle.calculateArea(10, 2.5);
        Assert.assertEquals(area, 25.0);
    }

    @Test
    public void testPerimeterWithDecimalValues() {
        double perimeter = rectangle.calculatePerimeter(10, 2.5);
        Assert.assertEquals(perimeter, 25.0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testAreaWithZeroLength() {
        rectangle.calculateArea(0, 3);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testPerimeterWithNegativeWidth() {
        rectangle.calculatePerimeter(4, -2);
    }
}