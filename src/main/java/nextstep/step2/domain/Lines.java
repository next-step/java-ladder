package nextstep.step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Lines {
    private final List<Line> lines = new ArrayList<>();

    public Lines(int inputLadderHeight, int participantsCount) {
        IntStream.range(0, inputLadderHeight).forEach(i -> lines.add(new Line(participantsCount)));
    }

    public List<Line> getLines() {
        return lines;
    }
}
