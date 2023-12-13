package EkamensLamndaUtrykk.Eks2022;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class konteEks22v {

    Function<String,Integer> length = a -> a.length();
    Function<String,Integer> length2 = String::length;
    Function<Integer,String> somTekst = (Integer a) -> String.valueOf(a);
    Function<Integer,String> somTeksts2 = String::valueOf;

    Predicate<LocalDate> dayofw = a -> a.getDayOfWeek().equals(DayOfWekk.MONDAY);
    Predicate<LocalDate> dayofw2 = LocalDate::DayOfWeek;

    public static void main(String[] args) {
        List<Person> venner = ...
       Comparator<Person> paanavn = Comparator.comparing(Person::getFultNavn);

        venner.stream().sorted(paanavn).forEach(System.out::println);

        Comparator<Person> paaBursdag = Comparator.comparing(Person::getFodtDato.withYear(2000));

        venner.stream().sorted(paaBursdag).forEach)(System.out::println);
    }

}
