package EkamensLamndaUtrykk.Eks2023;

import EkamensLamndaUtrykk.Eksamen;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Oppgave1 {
    Function<Integer,Boolean> riktigtall = h -> (h>= 0 && h<= 59); //function kan ta in en x antall variabel, i dette tilfelle bruker den integer og returner boolean
    Predicate<Boolean> booleanb = b -> !b; //predicate tar in en form for variabel og returnerer en boolean

    Predicate<String> startA = s -> s.startsWith("A");

    Function<String,Integer> countLenght = String::length;
    Consumer<String> test1 = System.out::println;

    public static void main(String[] args) {
        List<Eksamen> eksamener = Arrays.asList(
                new Eksamen("DAT102", LocalDate.of(2023, Month.MAY, 30), 150),
                new Eksamen("DAT107", LocalDate.of(2023, Month.MAY, 15), 160),
                new Eksamen("DAT108", LocalDate.of(2023, Month.JUNE, 6), 50));
        Comparator<Eksamen> kronologisk = (date1,date2) -> date1.getDato().compareTo(date2.getDato());
        Collections.sort(eksamener, kronologisk);

        eksamener.forEach(System.out::println);

        List<Eksamen> konteEks108 = eksamener.stream()
                .filter(e -> e.getEmnekode().equals("DAT108") && e.getDato().getMonth().equals(Month.JUNE))
                .toList();

        int snitt = (int) konteEks108.stream()
                        .mapToInt(Eksamen::getAntallOppmeldte)
                        .average()
                                .orElse(0.0);

        eksamener.stream()
                .map(Eksamen::getEmnekode)
                .distinct()
                .forEach(System.out::println);



    }

    List<String> fikse(List<String> liste, Function<String, String> f) {
        return liste.stream().map(f).toList();
    }
    void main() {

        List<String> liste = List.of("ola", "Per", "pÅL", "ESPEN");
        Function<String, String> navnefiks = str -> str.substring(0,1).toUpperCase() + str.substring(1,str.length()).toLowerCase();
        List<String> resultat = fikse(liste, navnefiks);
        System.out.println(resultat);
    }



}
