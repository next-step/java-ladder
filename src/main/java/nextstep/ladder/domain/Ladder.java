package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;
    private final Participants participants;

    private Ladder(List<Line> lines, Participants participants) {
        this.lines = lines;
        this.participants = participants;
    }

    public static Ladder createLadder(Participants participants, LadderResult result, int height, LineDecisionStrategy lineDescisionStrategy) {
        validateResult(participants, result);
        validateHeight(height);
        List<Line> lines = initializeLadder(height, participants, lineDescisionStrategy);
        return new Ladder(lines, participants);
    }

    private static void validateResult(Participants participants, LadderResult result) {
        if (!result.isMatchedWithParticipants(participants)) {
            throw new IllegalArgumentException("참가자 수와 결과 수가 일치해야 합니다.");
        }
    }

    private static void validateHeight(int height) {
        if (height < 1) {
            throw new IllegalArgumentException("사다리 높이는 1 이상이어야 합니다.");
        }
    }

    private static List<Line> initializeLadder(int height, Participants participants, LineDecisionStrategy lineDecisionStrategy) {
        return IntStream.range(0, height)
                .mapToObj(i -> createLine(participants.size(), lineDecisionStrategy))
                .collect(Collectors.toList());
    }

    private static Line createLine(int participantSize, LineDecisionStrategy lineDecisionStrategy) {
        Line line = Line.createLine(participantSize);
        IntStream.range(0, participantSize - 1)
                .filter(j -> lineDecisionStrategy.shouldDrawLine())
                .forEach(line::drawLine);
        return line;
    }

    public int participantCount() {
        return participants.size();
    }

    public List<String> participantNames() {
        return participants.names();
    }

    public List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public String findResult(String name) {
        int startPosition = participants.findParticipantIndex(name);
        return "";
    }
}
