package fominskiy;
// 3. Написать пример кода, который реализует принцип полиморфизма,
// на примере фигур — круг, квадрат, треугольник.

public class Circle extends Square {
    public Circle(String figure, int a) {
        super(figure, a);
    }

    @Override
    public void area() {
        System.out.println("Площадь фигуры " + figure + ": " + (Math.PI * a));
    }
}
