import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RightNumbers {
    public static String sortNumbers(String[] array) {
        List<Integer> sortedNumbers = Arrays.stream(array)
                .flatMap(s -> Arrays.stream(s.split(",")))
                .map(String::trim)
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());

        String result = sortedNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        return result;
    }
}
