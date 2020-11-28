package nextstep.ladder;

import java.util.Arrays;
import java.util.List;

public class InputView {
    public static List<String> splitName(String namesLine) {
        return Arrays.asList(namesLine.split(","));
    }

}
