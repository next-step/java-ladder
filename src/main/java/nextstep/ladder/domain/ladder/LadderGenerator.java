package nextstep.ladder.domain.ladder;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGenerator {

    public static Map<Ladder, Boolean> createLadders(int width, int height) {
        return IntStream.range(0, height)
                .boxed()
                .flatMap(i -> {
                    boolean[] previousHasLine = {false};  // 배열로 우회
                    return IntStream.range(0, width)
                            .mapToObj(j -> {
                                boolean currentHasLine = createHasHorizontalLine(previousHasLine[0]);
                                previousHasLine[0] = currentHasLine;
                                return Map.entry(new Ladder(i, j), currentHasLine);
                            });
                })
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue
                ));
    }

    private static boolean createHasHorizontalLine(Boolean previousValue) {
        if (previousValue) {
            return false;
        }
        return Math.random() < 0.5;
    }
}
