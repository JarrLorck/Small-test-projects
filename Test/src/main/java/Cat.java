public class Cat implements Furry{
    @Override
    public void groom() {

    }

    public static void main(String[] args) {
        Cat tom = new Cat();
        Bear pooh = new Bear();
        Furry f;
        tom.groom();
        pooh.groom();
        f = tom;
        f.groom();

        f = pooh;
        f.groom();

    }
}

class Bear implements Furry {
    @Override
    public void groom() {

    }
}

interface Furry {
    void groom();
}
