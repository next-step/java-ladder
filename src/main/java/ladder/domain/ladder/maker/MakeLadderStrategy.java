package ladder.domain.ladder.maker;

import ladder.domain.ladder.Line;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public interface MakeLadderStrategy {
    List<Line> makeBarLines();


}
