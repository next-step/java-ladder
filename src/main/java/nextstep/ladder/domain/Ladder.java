package nextstep.ladder.domain;

import nextstep.ladder.validator.LadderValidator;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    public static final int MIN_LADDER_HEIGHT = 1;
    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        LadderValidator.validateLadderMaxHeight(lines.size());
        this.lines = lines;
    }

    public static Ladder of(int numberOfParticipant, int height) {
        return new Ladder(createLines(numberOfParticipant - 1, height));
    }

    public static Ladder of(List<Line> lines) {
        return new Ladder(lines);
    }

    private static List<Line> createLines(int pointSize, int height) {
        return Stream.generate(() -> Line.of(RandomPointsGenerator.generate(pointSize)))
                .limit(height)
                .collect(Collectors.toList());
    }

    public int getHeight() {
        return this.lines.size();
    }

    public List<Line> getLines() {
        return this.lines;
    }

    public Map<Participant, String> move(Participants participants, List<String> prizes) {
        Map<Participant, String> prizeMap = new LinkedHashMap<>();

        for (Participant participant : participants.get()) {
            int position = move(participants.startPositionOf(participant));
            prizeMap.put(participant, prizes.get(position));
        }

        return Collections.unmodifiableMap(prizeMap);
    }

    private int move(int position) {
        for (Line line : this.lines) {
            position = line.move(position);
        }
        return position;
    }
}
