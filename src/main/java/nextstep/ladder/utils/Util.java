package nextstep.ladder.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Util {

    public static List<String> convertArrayToList(String[] splitResults) {
        return Arrays.stream(splitResults).collect(Collectors.toList());
    }
}
