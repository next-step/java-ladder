package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private List<Participant> participants;
    private List<Line> lines = new ArrayList<>();
    private int height;

    public Ladder() {
    }

    public Ladder(List<Participant> participants, int height) {
        this(participants, height, new HalfPossibilityStrategy());
    }

    public Ladder(List<Participant> participants, int height, PossibilityStrategy possibilityStrategy) {
        this.participants = participants;
        this.height = height;
        makeLadder(possibilityStrategy);
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public List<Line> getLines() {
        return lines;
    }

    public List<String> getParticipantsNames() {
        return participants.stream().
                map(participant -> participant.getName())
                .collect(Collectors.toList());
    }

    public int getHeight() {
        return height;
    }

    private void makeLadder(PossibilityStrategy possibilityStrategy) {
        IntStream.rangeClosed(0, height).forEach(value -> {
            lines.add(makeLine(possibilityStrategy));
        });
    }

    private Line makeLine(PossibilityStrategy possibilityStrategy) {
        return new Line(participants.size(), possibilityStrategy);
    }
}
