package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines;
    private final Participants participants;

    public Ladder(List<Line> lines, Participants participants) {
        this.lines = lines;
        this.participants = participants;
    }

    public static Ladder of(PositiveNumber height, Participants participants) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height.value(); i++) {
            lines.add(Line.initialize(participants, new RandomPointGenerator()));
        }

        return new Ladder(lines, participants);
    }

    public int totalParticipant() {
        return participants.countOfParticipants();
    }

    public int goingDown(int index) {
        for (Line line : lines) {
            index = line.move(index);
        }

        return index;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        lines.forEach(line -> stringBuilder.append(line.toString()).append("\n"));
        return stringBuilder.toString();
    }
}
