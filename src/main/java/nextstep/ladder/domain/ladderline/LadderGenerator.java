package nextstep.ladder.domain.ladderline;

import nextstep.ladder.domain.line.Line;
import nextstep.ladder.domain.point.RightPointStrategy;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static nextstep.ladder.utils.CommonConstant.NUMBER_ZERO;

public class LadderGenerator {

    public static LadderLine generateLadderLine(int height, int countOfUser, RightPointStrategy rightPointStrategy) {
        return new LadderLine(IntStream.range(NUMBER_ZERO, height)
                .mapToObj(line -> new Line(countOfUser, rightPointStrategy))
                .collect(Collectors.toList()));
    }

}
