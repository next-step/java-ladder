package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LadderTest {
    @Test
    void move() {
        List<String> names = Arrays.asList("a", "b", "c", "d");
        List<String> result = Arrays.asList("가", "나", "다", "라");

        Line line1 = new Line(Arrays.asList(true, false, true, false));
        Line line2 = new Line(Arrays.asList(false, true, false, false));
        Ladder ladder = new Ladder(Arrays.asList(line1, line2));
        Map<String, String> ladderResult = ladder.move(names, result);

        Arrays.asList(ladderResult.keySet()).stream()
                .forEachOrdered(key -> System.out.println(key + ": " + ladderResult.get(key)));
    }
}
