import java.util.stream.Stream;

public class RandStream {
    public static Stream<Long> randomStream(long seed, long a, long c, long m){
        return Stream.iterate(seed, x -> (a * x + c) % m);
    }
}
