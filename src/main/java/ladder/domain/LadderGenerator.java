package ladder.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGenerator {
    
    public static Ladder generateLadder(int height, Players players) {
        return new Ladder(IntStream.range(0, height)
                .mapToObj(x -> LadderLine.init(players))
                .collect(Collectors.toList()));
    }
    
}
