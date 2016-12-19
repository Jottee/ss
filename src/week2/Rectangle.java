package week2;

public class Rectangle {
    private int length;
    private int width;

    /**
     * Create a new Rectangle with the specified length and width.
     */
    //@ requires length >= 0;
    //@ requires width >= 0;
    //@ ensures length() == length;
    //@ ensures width() == width;
    public Rectangle(int theLength, int theWidth) {
        assert length >= 0;
        assert width >= 0;
        this.length = theLength;
        this.width = theWidth;
        assert length() == length;
        assert width() == width;
    }

    /**
     * The length of this Rectangle.
     */
    //@ ensures \result >= 0;
    public int length() {
        return 0;
    }

    /**
     * The width of this Rectangle.
     */
    //@ ensures \result >= 0;
    public int width() {
        return 0;
    }

    /**
     * The area of this Rectangle.
     */
    //@ ensures area() == length() * width();
    public int area() {
        return length() * width();
    }

    /**
     * The perimeter of this Rectangle.
     */
    //@ ensures \result == 2*length() + 2*width();
    public int perimeter() {
        return 0;
    }
}
