package nextstep.ladder.domain;

import nextstep.ladder.util.pointsgenerator.PointsGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
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
        Map<String, String> result = new HashMap<>();
        int participantsSize = participants.getNumberOfParticipants().getValue();

        for (int i = 0; i < participantsSize; i++) {
            int resultIndex = getResultOfPerLine(i, lines.size() - 1);
            result.put(participants.get(i).getValue(), executionResults.get(resultIndex));
        }

        return result;
    }

    private int getResultOfPerLine(int currIndex, int lineIndex) {
        if (lineIndex == 0) {
            return lines.get(lineIndex).moveIndex(currIndex);
        }

        return lines.get(lineIndex).moveIndex(getResultOfPerLine(currIndex, lineIndex - 1));
    }
}
