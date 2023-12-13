package EkamensLamndaUtrykk;

import bokanmeldese.eksamen23VbokanmeldserDat108.Model.Bok;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class eksamenh21 {
    Consumer<String> printPlain = System.out::println;
    Consumer<String> printMedStjerner = x -> System.out.println("*" + x +"*");
    String baklengs(String s) {
        return  new StringBuilder(s).reverse().toString();
    }
    Consumer<String> printBaklengs = x-> System.out.println(baklengs(x));

    List<Bokk> boker = List.of(
            new Bokk("Core Java Volume I", 2022, List.of("Cay Horstmann")),
            new Bokk("Effective Java", 2017, List.of("Cay Horstmann")),
            new Bokk("Head First Java", 2005, List.of("Kathy Sierra", "Bert Bates")),
            new Bokk("Java Concurrency in Practice", 2006,
                    List.of("Brian Goetz", "Tim Peierls", "Joshua Bloch"))
            );

    List<Bokk> bokFor2015 = boker.stream()
            .filter(x -> x.getAar() <= 2015)
            .collect(Collectors.toList());

    List<String> javaBok = boker.stream()
            .filter(b -> b.tittel.contains("Java"))
            .map(b->b.tittel)
            .collect(Collectors.toList());
    String etternavn(String s) {
        return s.substring(s.lastIndexOf(""));
    }
    Comparator<String> paaEtternavn = (s1,s2) -> etternavn(s1).compareTo(etternavn(s2));
    List<String> forfattere = boker.stream()
            .flatMap(b -> b.forfattere.stream())
            .distinct()
            .sorted(paaEtternavn)
            .collect(Collectors.toList());


}
