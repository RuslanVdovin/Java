package lesson5;

public class PersonalTest {

    public static void main(String[] args) {

    Personal personal1 = new Personal("James Jonson", 65, "G.M.",
            "JJ@email.ru", 7775556697l, 355000);

    Personal personal2 = new Personal("Иванов Иван Иванович", 50, "зам.директора",
            "ivanov@email.ru", 89001117551l, 95000);

    Personal personal3 = new Personal("Smirnov Roman", 37, "Manager",
            "smirnov@email.ru", 89997445512l, 40000);

    Personal personal4 = new Personal("Ivanova Anna", 41, "Administrator",
            "Anna@email.ru", 11112222554l, 40000);

    Personal personal5 = new Personal("Rostova Natasha", 22, "Seller",
            "dasha@email.ru", 55587789655l, 25000);

// Вывод через ArrayList
        Personal.sortByAge(40);
        System.out.println();

// Вывод через Array
    Personal.personals[0] = personal1;
    Personal.personals[1] = personal2;
    Personal.personals[2] = personal3;
    Personal.personals[3] = personal4;
    Personal.personals[4] = personal5;

        System.out.println(Personal.sortAge(40));



    }
}

