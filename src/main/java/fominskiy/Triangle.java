package fominskiy;
// 3. Написать пример кода, который реализует принцип полиморфизма,
// на примере фигур — круг, квадрат, треугольник.

public class Triangle extends Square {
    int h;
    public Triangle(String figure, int a,int h) {
        super(figure, a);
        this.h = h;
    }

    @Override
    public void area() {
        System.out.println("Площадь фигуры " + figure + ": " + (0.5 * h * a));
    }
}
