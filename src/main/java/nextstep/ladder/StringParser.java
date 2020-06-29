package nextstep.ladder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringParser {

    public static List<String> splitNames(String input){
        return Arrays.stream(input.split(","))
                .collect(Collectors.toList());
    }
}
