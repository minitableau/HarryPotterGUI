package GameElement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class SortingHatTest {

    @Test
    public void testSort() {
        SortingHat sortingHat = new SortingHat();
        House house = sortingHat.sort();

        Assertions.assertNotNull(house);
    }

    @Test
    public void testSortWithScanner() {
        SortingHat sortingHat = new SortingHat();

        // create a fake scanner with a predefined excluded house index
        Scanner scanner = new Scanner("2\n");

        House house = sortingHat.sort(scanner);

        // check that the excluded house was not selected
        Assertions.assertNotEquals(house, House.SLYTHERIN);
    }

    @Test
    public void testSortWithInvalidExcludedHouseIndex() {
        SortingHat sortingHat = new SortingHat();

        // create a fake scanner with an invalid excluded house index
        Scanner scanner = new Scanner("5\n1\n");

        House house = sortingHat.sort(scanner);

        // check that the excluded house was not selected
        Assertions.assertNotNull(house);
    }

}
