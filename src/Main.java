import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ivan","Mike","Ilya","Vovan","Peter","Bryan");
        String numbers[] = {"1, 2, 0", "4, 5"};

        Stream<String> stream1 = Stream.of("A", "B", "C");
        Stream<String> stream2 = Stream.of("1", "2", "3", "4");

        long a = 25214903917L;
        long c = 11L;
        long m = (long) Math.pow(2,48);
        long seed = 12234L;


        System.out.println(OddIndexNames.getOddIndexNames(names));
        System.out.println(UpperCaseSortList.Sorting(names));
        System.out.println(RightNumbers.sortNumbers(numbers));

        Stream<Long> random = RandStream.randomStream(seed,a,c,m);
        random.limit(10).forEach(System.out::println);

        Stream<String> zippedStream = ZIP.zip(stream1,stream2);
        zippedStream.forEach(System.out::print);


    }
}