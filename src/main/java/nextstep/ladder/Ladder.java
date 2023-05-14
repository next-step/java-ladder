package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private int height = 0;
    private Participant participant;
    private final List<Line> lines;

    public Ladder(int height) {
        validateHeight(height);
        this.height = height;
        this.participant = new Participant();
        this.lines = new ArrayList<>();
    }

    public Ladder(int height, Participant participant, LineStrategy lineStrategy) {
        validateHeight(height);
        this.height = height;
        this.participant = participant;
        this.lines = drawLine(height, participant, lineStrategy);
    }

    private List<Line> drawLine(int height, Participant participant, LineStrategy lineStrategy) {
        return IntStream.range(0, height)
                .mapToObj(h -> new Line(participant, lineStrategy))
                .collect(Collectors.toList());
    }

    private void validateHeight(int height) {
        if (height < 2) {
            throw new IllegalArgumentException("사다리 높이는 2 이상이어야 합니다.");
        }
    }

    public int getHeight() {
        return height;
    }

    public Participant getParticipant() {
        return participant;
    }

    public List<Line> getLines() {
        return lines;
    }
}
