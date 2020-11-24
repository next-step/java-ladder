package nextstep.ladder.domain;

import nextstep.ladder.util.pointsgenerator.PointsGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    private Ladder(Participants participants, Height height) {
        lines = new ArrayList<>(height.getValue());

        IntStream.range(0, height.getValue())
                .forEach(index -> lines.add(Line.from(participants)));
    }

    private Ladder(Participants participants, Height height, PointsGenerator pointsGenerator) {
        lines = new ArrayList<>(height.getValue());

        IntStream.range(0, height.getValue())
                .forEach(index -> lines.add(Line.of(participants, pointsGenerator)));
    }

    public static Ladder of(Participants participants, Height height) {
        return new Ladder(participants, height);
    }

    public static Ladder of(Participants participants, Height height, PointsGenerator pointsGenerator) {
        return new Ladder(participants, height, pointsGenerator);
    }

    public void linesForEach(Consumer<Line> consumer) {
        lines.forEach(consumer);
    }

    public Map<String, String> resultOf(Participants participants, ExecutionsResults executionResults) {
        return IntStream.range(0, participants.getNumberOfParticipants().getValue())
                .boxed()
                .collect(Collectors.toMap(i -> participants.get(i).getValue(), i -> executionResults.get(getResult(i))));
    }

    private int getResult(int currIndex) {
        return getResultOfPerLine(currIndex, lines.size() - 1);
    }

    private int getResultOfPerLine(int currIndex, int lineIndex) {
        if (lineIndex == 0) {
            return lines.get(lineIndex).moveIndex(currIndex);
        }

        return lines.get(lineIndex).moveIndex(getResultOfPerLine(currIndex, lineIndex - 1));
    }
}
