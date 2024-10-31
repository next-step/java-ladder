package nextstep.ladder.domain;

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

    public static Ladder createLadder(Participants participants, int height, LineDecisionStrategy lineDescisionStrategy) {
        validateHeight(height);
        List<Line> lines = initializeLadder(height, participants, lineDescisionStrategy);
        return new Ladder(lines, participants);
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

    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append(participants.getParticipants()
                        .stream()
                        .map(Participant::getFormattedName)
                        .collect(Collectors.joining(" ")))
                .append("\n");

        lines.forEach(line -> {
            result.append(drawLine(line)).append("\n");
        });

        return result.toString();
    }

    private String drawLine(Line line) {
        StringBuilder builder = new StringBuilder();
        builder.append("    ");
        IntStream.range(0, participants.size() - 1)
                .forEach(i -> {
                    builder.append("|");
                    if (i < line.size() && line.hasLine(i)) {
                        builder.append("-----");
                    } else {
                        builder.append("     ");
                    }
                });
        builder.append("|");
        return builder.toString();
    }
}
