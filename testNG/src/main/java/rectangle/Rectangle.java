package rectangle;

public class Rectangle {

    public double calculateArea(double length, double width) {
        if (length <= 0 || width <= 0) {
            throw new IllegalArgumentException("Chiều dài và chiều rộng phải > 0");
        }
        return length * width;
    }

    public double calculatePerimeter(double length, double width) {
        if (length <= 0 || width <= 0) {
            throw new IllegalArgumentException("Chiều dài và chiều rộng phải > 0");
        }
        return 2 * (length + width);
    }
}
