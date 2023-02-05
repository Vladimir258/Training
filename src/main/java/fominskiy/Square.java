package fominskiy;
// 3. Написать пример кода, который реализует принцип полиморфизма,
// на примере фигур — круг, квадрат, треугольник.

public class Square implements Figure {
    int a;
    String figure;

    public Square(String figure, int a) {
        this.figure = figure;
        this.a = a;
    }

    public int getA() {
        return a;
    }
    @Override
    public void area() {
        System.out.println("Площадь фигуры " + figure + ": " + (a * a));
    }
}
