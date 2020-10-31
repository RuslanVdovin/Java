package lesson6;

public class Cats extends Animals{

    protected int runDistance;
    protected double jumpHeight;
    protected int swimDistance;
    private static int catCounter = 0;

    public Cats() {
        runDistance = 200;
        jumpHeight = 2;
        catCounter++;
    }



    public Cats(int runDistance, double jumpHeight) {
        this.runDistance = runDistance;
        this.jumpHeight = jumpHeight;
        catCounter++;
    }

    @Override
    public boolean swim(int swimDistance) {
        System.out.println("Cat can't swim");
        return false;
    }

    public static void quantityCats() {
        System.out.println("Cats quantity = " + catCounter);
    }

    @Override
    public void voice() {
        System.out.println("Cat started to meow");
    }
}
