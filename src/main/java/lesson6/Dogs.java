package lesson6;

public class Dogs extends Animals {

    protected int runDistance;
    protected double jumpHeight;
    protected int swimDistance;
    private static int dogCounter = 0;


    public Dogs(int runDistance, double jumpHeight, int swimDistance) {
        this.runDistance = runDistance;
        this.jumpHeight = jumpHeight;
        this.swimDistance = swimDistance;
        dogCounter++;
    }

    public Dogs() {
        runDistance = 500;
        jumpHeight = 0.5;
        swimDistance = 5;
        dogCounter++;
    }

    @Override
    public boolean swim(int swimDistance) {
        if (this.swimDistance >= swimDistance) {
            System.out.println("Dog swim " + swimDistance + " meters");
            return true;
        } else System.out.println("Dog can't swim so far");
        return false;
    }

    @Override
    public void voice() {
        System.out.println("Dog begin to bark");
    }

    public static void quantityDogs() {
        System.out.println("Dogs quantity = " + dogCounter);
    }
}
