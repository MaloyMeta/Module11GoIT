import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UpperCaseSortList {
    public static List<String> Sorting(List<String> info){
        return info.stream()
                .map(String::toUpperCase)
                .sorted((s1, s2) -> s2.compareTo(s1))
                .collect(Collectors.toList());
    }
}
