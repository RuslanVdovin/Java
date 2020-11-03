package lesson6;

public class TestAnimal {

    public static void main(String[] args) {

        Cats cat1 = new Cats();
        Dogs dog1 = new Dogs();
        Dogs dog2 = new Dogs();
        Cats cat = new Cats(200, 2);
        Dogs dog = new Dogs(350, 0.2, 3);

        cat.voice();
        cat.jump(1.5, cat);
        cat.swim(5);
        cat.run(100, cat);

        cat1.jump(10, cat1);

        dog.run(200, dog);
        dog.swim(5);
        dog.jump(0.2, dog);
        dog.voice();

        Cats.quantityCats();

        Dogs.quantityDogs();

        Animals.quantityAnimals();

    }
}
