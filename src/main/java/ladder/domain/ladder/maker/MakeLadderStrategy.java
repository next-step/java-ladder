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

    static MakeLadderStrategy getPassiveMaker(Boolean[]... barMatrix){
        return ()-> Arrays.stream(barMatrix)
                .map(Line::of)
                .collect(Collectors.toList());
    }
}
