package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {
    private final List<Line> lines;

    public Lines(int countOfParticipant, Height height, GenerateLadderPointStrategy generateLadderPointStrategy) {
        this.lines = setLines(countOfParticipant, height, generateLadderPointStrategy);
    }

    private List<Line> setLines(int countOfParticipant, Height height, GenerateLadderPointStrategy generateLadderPointStrategy) {
        return IntStream.range(0, height.getHeight())
                .mapToObj(i -> new Line(countOfParticipant, generateLadderPointStrategy))
                .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

}
