package fominskiy;

public class Main {

    public static void main(String[] args) {
        Person p = new Person.Builder()
                .addFirstName("First")
                .addLastName("First")
                .addMiddleName("First")
                .addCountry("First")
                .addAddress("First")
                .addPhone("First")
                .addAge(123)
                .addGender("First")
                .build();


        Square[] figures = new Square[5];
        Square square = new Square("квадрат", 2);
        Circle circle = new Circle("круг", 3);
        Triangle triangle = new Triangle("треугольник", 4, 3);

        figures[0] = square;
        figures[1] = circle;
        figures[2] = triangle;
        figures[3] = new Square("квадрат 2", 5);
        figures[4] = new Circle("круг 2", 7);

        for (int i = 0; i < figures.length; i++) {
            figures[i].area();
        }
    }
}