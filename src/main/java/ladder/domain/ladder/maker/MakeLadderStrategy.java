package ladder.domain.ladder.maker;

import ladder.domain.ladder.Line;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public interface MakeLadderStrategy {
    List<Line> makeBarLines();

    static MakeLadderStrategy getRandomMaker(int size, int height) {
        return new RandomLadderMaker(size, height);
    }

    static MakeLadderStrategy getPassiveMaker(Line... lines){
        return ()-> Arrays.stream(lines)
                .collect(Collectors.toList());
    }
}
