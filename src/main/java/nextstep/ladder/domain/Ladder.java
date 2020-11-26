package nextstep.ladder.domain;

import nextstep.ladder.util.pointsgenerator.PointsGenerator;

import java.util.ArrayList;
import java.util.LinkedHashMap;
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

    public Results resultOf(Participants participants, ExecutionResults executionResults) {
        Map<Name, String> resultsMap = IntStream.range(0, participants.getNumberOfParticipants().getValue())
                .boxed()
                .collect(Collectors.toMap(participants::get, i -> executionResults.get(getResult(i)),
                        (k1, k2) -> {
                            throw new IllegalStateException(Participants.DUPLICATE_NAME_EXIST_ERR_MSG);
                        },
                        LinkedHashMap::new));

        return Results.of(resultsMap);
    }

    private int getResult(int currIndex) {
        return getResult(currIndex, lines.size() - 1);
    }

    private int getResult(int currIndex, int lineIndex) {
        Line line = lines.get(lineIndex);
        if (lineIndex == 0) {
            return line.getNextIndexOf(currIndex);
        }

        int nextIndex = getResult(currIndex, lineIndex - 1);
        return line.getNextIndexOf(nextIndex);
    }
}
