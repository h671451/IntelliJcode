import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Oppgave3Test {


    @Test //test hvis tabellen er tom, vi tester begger algorytmene
    void testEmptyArray() {
        int[] emptyArray = {};
        var search = new Oppgave3();
        assertFalse(search.linearSearch(emptyArray, 5));
        assertFalse(search.binarySearch(emptyArray, 5));
    }

    @Test //tester hvis tabellen bare har en element i tabellen
    void testSingleElementArray() {
        int[] singleElementArray = {5};
        var search = new Oppgave3();
        assertFalse(search.linearSearch(singleElementArray, 1));
        assertTrue(search.linearSearch(singleElementArray, 5));
        assertFalse(search.binarySearch(singleElementArray, 1));
        assertTrue(search.binarySearch(singleElementArray, 5));
    }


    @Test //tester i usortert tabell at du returner riktig boolean verdi
    public void testLinearSearchForUsortert(){
        var search = new Oppgave3();
        int[] array = {1,8,6,4,2,7};
        //tester at det er sant hvis u finner riktig verdi
        assertTrue(search.linearSearch(array,8));

        //tester at det er usant hvis du ikke finner verdien
        assertFalse(search.linearSearch(array,5));
    }

    @Test  //tester i sortert tabell at du returner riktig boolean verdi
    public void testLinearSearchForSortert(){
        var search = new Oppgave3();
        int[] array = {1,2,3,4,5,6};
        //tester at det er sant hvis u finner riktig verdi
        assertTrue(search.linearSearch(array,6));
        //tester at det er usant hvis du ikke finner verdien
        assertFalse(search.linearSearch(array,8));
    }

    @Test  // tester i sortert tabell at du returnerer riktig boolean verdi.
    public void testBinarySearch(){
        var search = new Oppgave3();

        int [] arr = {1,2,3,4,5,6,7,8,9,10};
        int target = 7;
        //tester at det er sant hvis u finner riktig verdi
        assertTrue(search.binarySearch(arr, target));
        //tester at det er usant hvis du  ikke finner verdien
        target = 11;
        assertFalse(search.binarySearch(arr, target));

    }
}