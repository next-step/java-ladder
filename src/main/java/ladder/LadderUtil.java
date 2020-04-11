package ladder;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderUtil {

    public static List<String> splitStringByComma(String text) {
        return Arrays.stream(text.split(",")).collect(Collectors.toList());
    }
}
