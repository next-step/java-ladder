package nextstep.ladder.domain.line;

import nextstep.ladder.domain.point.RightPointStrategy;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static nextstep.ladder.utils.CommonConstant.NUMBER_ZERO;

public class LadderLineGenerator {

    public static LadderLines generateLadderLine(int height, int countOfUser, RightPointStrategy rightPointStrategy) {
        return new LadderLines(IntStream.range(NUMBER_ZERO, height)
                .mapToObj(line -> new LadderLine(countOfUser, rightPointStrategy))
                .collect(Collectors.toList()));
    }

}
