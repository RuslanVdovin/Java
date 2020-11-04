package lesson7;

public class Cat {

    private final String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        satiety = false;
    }

    public int getAppetite() {
        return appetite;
    }

    public void eat(Plate plate){
        int j = plate.getFood();
        if (j > 0) {
            plate.decreaseFood(appetite);
            saturation(j);
            if (appetite <= 1) satiety = true;
        }
        else if (plate.getFood() == 0) {
            System.out.println("Food in this plate over! " +
                    "add food in this plate.");
        }
    }

    private void saturation(int i) {
        while(i > 0 && appetite > 0) {
            i--;
            appetite--;
        }
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", appetite=" + appetite +
                ", satiety=" + satiety +
                '}';
    }
}
