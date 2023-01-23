package fominskiy;
// 2. Описать ошибки в коде (см. задание в методичке) и предложить варианты оптимизации.
interface Moveable {
    void move();
}

interface Stopable {
    void stop();
}
abstract class Car {
    public Engine engine;
    private String color;
    private String name;

    public Car(Engine engine, String color, String name) {
        this.engine = engine;
        this.color = color;
        this.name = name;
    }

    protected void start() {
        System.out.println("Car starting");
    }

    abstract void open();

    public Engine getEngine() {
        return engine;
    }


    public String getColor() {
        return color;
    }


    public String getName() {
        return name;
    }

}

class LightWeightCar extends Car implements Moveable {

    public LightWeightCar(Engine engine, String color, String name) {
        super(engine, color, name);
    }

    @Override
    public void move() {
        System.out.println("Car is moving");
    }

    @Override
    void open() {
        System.out.println("Car is open");
    }
}

class Lorry extends Car implements Moveable, Stopable {

    public Lorry(Engine engine, String color, String name) {
        super(engine, color, name);
    }

    @Override
    public void move() {
        System.out.println("Car is moving");
    }

    @Override
    public void stop() {
        System.out.println("Car is stop");
    }

    @Override
    void open() {

    }
}

class Engine {

}


