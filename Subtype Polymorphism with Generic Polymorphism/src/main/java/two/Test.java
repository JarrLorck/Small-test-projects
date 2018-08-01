package two;

public class Test {

    public static void main(String[] args) {
        AnyObject anyObject = new AnyObject();
        AnyContainer anyContainer = new AnyContainer<AnyObject>();

        PhysicalObject physicalObject = new PhysicalObject();
        PhysicalContainer physicalContainer = new PhysicalContainer<PhysicalObject>();

        Fruit fruit = new Fruit();
        FruitContainer fruitContainer = new FruitContainer<Fruit>();

        GoldenDelicious g1 = new GoldenDelicious();
        FruitContainer<Apple> container = g1.container();
        Gala g2 = new Gala();

        g1.compareTo(g2);
    }
}


class AnyContainer<E extends AnyObject<E>>{}

class AnyObject<O extends AnyObject<O>> implements Comparable<O> {
    @Override
    public int compareTo(final O o) {
        return 0;
    }

    public AnyContainer<O> container() { return null; }
}

class PhysicalContainer<E extends PhysicalObject<E>> extends AnyContainer<E> {}

class PhysicalObject<O extends PhysicalObject<O>> extends AnyObject<O> {}


class FruitContainer<E extends Fruit<E>> extends PhysicalContainer<E> {

}

class Fruit<O extends Fruit<O>> extends PhysicalObject<O> {
    @Override
    public FruitContainer<O> container() {
        return new FruitContainer<O>();
    }
}

class Apple extends Fruit<Apple> {}

class GoldenDelicious extends Apple {}
class Gala extends Apple {}
