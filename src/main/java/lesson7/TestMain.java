package lesson7;

import java.util.ArrayList;
import java.util.List;

public class TestMain {

    private final List<Cat> cats = new ArrayList<>();

    public List<Cat> getCats() {
        return cats;
    }

    public static void main(String[] args) {

        TestMain t = new TestMain();

        Cat cat1 = new Cat("Tom", 4);
        Cat cat2 = new Cat("Barsik", 8);
        Cat cat3 = new Cat("Pushok", 5);

        Plate plate1 = new Plate(10);

        cat1.eat(plate1);
        System.out.println(cat1);
        plate1.info();

        cat2.eat(plate1);
        System.out.println(cat2);
        plate1.info();

        cat3.eat(plate1);
        System.out.println(cat3);

        plate1.addFood(300);
        plate1.info();

        for (int i = 0; i < 10; i++) {
           t.cats.add(new Cat("name" + i, (int)(Math.random()*100)));
        }
            System.out.println(t.getCats());

       t.getCats().forEach(cat -> cat.eat(plate1));
       plate1.info();
        System.out.println(t.getCats());
    }
}

