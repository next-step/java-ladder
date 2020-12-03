package nextstep.ladder.domain;

import nextstep.ladder.util.pointsgenerator.PointsGenerator;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<LadderLine> ladderLines;

    private Ladder(Participants participants, Height height, Function<Integer, LadderLine> ladderLineFactory) {
        ladderLines = new ArrayList<>(height.getValue());
        int sizeOfPerson = participants.getSizeOfPerson().getValue();
        IntStream.range(0, height.getValue())
                .forEach(index -> ladderLines.add(ladderLineFactory.apply(sizeOfPerson)));
    }

    public static Ladder of(Participants participants, Height height) {
        return new Ladder(participants, height, LadderLine::init);
    }

    public static Ladder of(Participants participants, Height height, PointsGenerator pointsGenerator) {
        return new Ladder(participants, height, sizeOfPerson -> LadderLine.init(sizeOfPerson, pointsGenerator));
    }

    public void linesForEach(Consumer<LadderLine> consumer) {
        ladderLines.forEach(consumer);
    }

    public ExecutionResults resultOf(Participants participants, ResultCandidates resultCandidates) {
        Map<Name, ResultCandidate> resultsMap = IntStream.range(0, participants.getSizeOfPerson().getValue())
                .boxed()
                .collect(Collectors.toMap(participants::get, i -> resultCandidates.get(getResultIndexOf(i)),
                        (k1, k2) -> {
                            throw new IllegalStateException(Participants.DUPLICATE_NAME_EXIST_ERR_MSG);
                        },
                        LinkedHashMap::new));

        return ExecutionResults.of(resultsMap);
    }

    private int getResultIndexOf(int index) {
        return getResultIndexOf(index, ladderLines.size() - 1);
    }

    private int getResultIndexOf(int index, int lineIndex) {
        LadderLine line = ladderLines.get(lineIndex);
        if (lineIndex == 0) {
            return line.move(index);
        }

        int nextIndex = getResultIndexOf(index, lineIndex - 1);
        return line.move(nextIndex);
    }
}
