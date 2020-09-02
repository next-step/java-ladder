package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static nextstep.ladder.utils.CommonConstant.NUMBER_ZERO;

public class LadderLine {

    private List<Line> ladders;

    private LadderLine(List<Line> ladders) {
        this.ladders = ladders;
    }

    public static LadderLine of(int height, int countOfUser, LadderGenerator ladderGenerator) {
        List<Line> lines = IntStream.range(NUMBER_ZERO, height)
                .mapToObj(line -> new Line(countOfUser, ladderGenerator))
                .collect(Collectors.toList());

        return new LadderLine(lines);
    }

    public Line getLine(int index) {
        return ladders.get(index);
    }

    public int size() {
        return ladders.size();
    }

}
