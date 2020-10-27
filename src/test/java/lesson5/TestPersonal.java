package lesson5;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestPersonal {

    @Before
    public void getPersonal() {
        Personal personal1 = new Personal("Oleg", 55, "cleaner",
                "21231@email.ru", 22313123123l, 10000);
        Personal personal2 = new Personal("Alice", 27, "Developer",
                "Alice@email.ru", 8959958995l, 300000);
        Personal personal3 = new Personal("Andrey", 37, "Engener",
                "Oleg@email.ru", 89595648454l, 150000);

    }

    @Test
    public void nameNotNull() {
        Personal expected = new Personal("Oleg", 55, "cleaner",
                "21231@email.ru", 22313123123l, 10000);
        Assert.assertNotNull(expected.getFullName());

    }

    @Test
    public void age() {
        Personal actual = new Personal("Oleg", 55, "cleaner",
                "21231@email.ru", 22313123123l, 10000);

        int expected = 55;

        Assert.assertEquals(actual.getAge(), expected);

    }
}
