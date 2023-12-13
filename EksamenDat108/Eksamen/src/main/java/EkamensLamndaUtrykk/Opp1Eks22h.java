package EkamensLamndaUtrykk;

import java.util.Comparator;
import java.util.List;
import java.util.function.*;

public class Opp1Eks22h {
    Consumer<String> printA = a -> System.out.println(a);
    Comparator<String> aCompareB = (a,b) -> a.compareTo(b);
    Function<Integer, Integer> gange = a -> a*a;
    Predicate<Integer> tallStorreEnn0 = a -> a >0;
    BiFunction<Integer, Integer,Integer> addere = (a, b) -> a+b;

    public static List<Integer> utplukk(List<Integer> liste, Predicate<Integer> b) {
        return liste.stream().filter(b).toList();
    }
    public static void main(String[] args) {
        List<Integer> liste = List.of(1,2,3,4,5,6,7,8,9);
        List<Integer> resultat = utplukk(liste, x->x%3==0);
        System.out.println(resultat);

        List<Bil> biler = List.of(
                new Bil("EK 12345", "Tesla model Y"),
                new Bil("EV 52345", "Tesla model Y"),
                new Bil("SV 12346", "Mazda 5"),
                new Bil("SU 24680", "Volvo 240"),
                new Bil("EL 24683", "Nissan Leaf"));

        List<Bil> eSkilt = biler.stream()
                .filter(b -> b.getSkilt().startsWith("E"))
                .toList();

        eSkilt.stream()
                .map(Bil::getBilMerke)
                .distinct()
                .forEach(System.out::println);


        List<Kundedata> kundeliste = List.of(
                new Kundedata("Arne", 1234),
                new Kundedata("Per", 2234),
                new Kundedata("Pål", 1000),
                new Kundedata("Emma", 4000),
                new Kundedata("Ine", 5234),
                new Kundedata("Tone", 1111));

        int totalForbruk = kundeliste.stream()
                .mapToInt(Kundedata::getForbruk)
                .sum();


        public double beregnTotalInntekt(
                List<Kundedata> kundeliste, ToDoubleFunction<Kundedata> prisKalku) {
            return kundeliste.stream().mapToDouble(prisKalku).sum();
        }

        double paalPrisBeregning = beregnTotalInntekt(kundeliste, p -> 1,5 * p.getForbruk());//tar en liste av kunder også bruker man lamdautrykk t

    }




}


