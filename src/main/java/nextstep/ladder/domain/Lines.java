package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {
    private final List<Line> lines;

    public Lines(int countOfParticipant, int height, GenerateLadderPointStrategy generateLadderPointStrategy) {
        this.lines = generateLines(countOfParticipant, height, generateLadderPointStrategy);
    }

    public int move(int position) {
        for (Line line : lines) {
            position = line.move(position);
        }
        return position;
    }

    private List<Line> generateLines(int countOfParticipant, int height, GenerateLadderPointStrategy generateLadderPointStrategy) {
        return IntStream.range(0, height)
                .mapToObj(i -> new Line(countOfParticipant, generateLadderPointStrategy))
                .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

}
