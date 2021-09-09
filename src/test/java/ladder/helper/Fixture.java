package ladder.helper;

import ladder.domain.LadderSize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Fixture {
    public static LadderSize ladderSize() {
        return new LadderSize(10, 10);
    }

    public static List<Boolean> generatedLines() {
        return new ArrayList<>(Arrays.asList(true, false, true, false, true, false, true, false, true, false));
    }
}
