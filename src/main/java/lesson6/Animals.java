package lesson6;

public abstract class Animals {

    protected int runDistance;
    protected double jumpHeight;
    protected int swimDistance;
    private static int animalsCounter = 0;

    public Animals() {
        animalsCounter++;
    }

    public int getRunDistance() {
        return runDistance;
    }

    public double getJumpHeight() {
        return jumpHeight;
    }

    public int getSwimDistance() {
        return swimDistance;
    }

    public void run(int runDistance, Animals animals) {
        if (this.runDistance >= runDistance) {
            System.out.println(animals.getClass().getSimpleName() + " run " + runDistance + " meters");
        } else System.out.println(animals.getClass().getSimpleName() + " can't run so far");
    }

    public void jump(double jumpHeight, Animals animals) {
        if (this.jumpHeight >= jumpHeight) {
            System.out.println(animals.getClass().getSimpleName() + " jumped " + jumpHeight + " meters");
        } else {
            System.out.println(animals.getClass().getSimpleName() + " can't jump so height");
        }
    }

    public abstract boolean swim(int swimDistance);

    public abstract void voice();

    public static void quantityAnimals() {
        System.out.println("Animals quantity = " + animalsCounter);
    }

}
