package lesson5;

import java.util.ArrayList;

public class Personal {

    private String fullName;
    private int age;
    private String post;
    private String email;
    private long phoneNumber;
    private long salary;
    private static ArrayList <Personal> pers = new ArrayList<>();
    public static Personal[] personals = new Personal[5];

    public Personal(String fullName, int age, String post, String email, long phoneNumber, long salary) {
        this.fullName = fullName;
        this.age = age;
        this.post = post;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        pers.add(this);
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

// выборка через Array
    public static Personal sortAge(int age) {
        for (Personal personal : personals) {
            if (personal.getAge() > age) {
                return personal;
            }
        }
        return null;
    }

// выборка через ArrayList
    public static void sortByAge(int age) {
        int count = 0;
        for (Personal personal : pers) {
            if (personal.getAge() > age) {
                System.out.println(personal);
                count++;
            }
        }
        if (count == 0)
            System.out.println("Сотрудников старше" + age + " не обнаружено");
    }

    @Override
    public String toString() {
        return "Personal " +
                "fullName='" + fullName + '\'' +
                " age=" + age + '\'' +
                " post='" + post + '\'' +
                " email='" + email + '\'' +
                " phoneNumber=" + phoneNumber + '\'' +
                " salary=" + salary;
    }
}
