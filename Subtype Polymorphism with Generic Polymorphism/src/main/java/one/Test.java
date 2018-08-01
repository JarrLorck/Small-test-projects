package one;

public class Test {

    public static void main(String[] args) {
        AnyObject anyObject = new AnyObject();
        AnyContainer<AnyObject> anyContainer = new AnyContainer<AnyObject>();

        PhysicalObject physicalObject = new PhysicalObject();
        PhysicalContainer<PhysicalObject> physicalContainer = new PhysicalContainer<PhysicalObject>();

        Fruit fruit = new Fruit();
        FruitContainer<Fruit> fruitContainer = new FruitContainer<Fruit>();
    }
}


class AnyContainer<E extends AnyObject> {}

class AnyObject {}

class PhysicalContainer<E extends PhysicalObject> extends AnyContainer<E> {}

class PhysicalObject extends AnyObject {}


class FruitContainer<E extends Fruit> extends PhysicalContainer<E> {}

class Fruit extends PhysicalObject {}
