package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final Height height;
    private final Participant participant;
    private final List<Line> lines;

    public Ladder(int height) {
        this(height, new Participant(), new RandomLineStrategy());
    }

    public Ladder(int height, Participant participant, LineStrategy lineStrategy) {
        this.height = new Height(height);
        this.participant = participant;
        this.lines = drawLine(height, participant, lineStrategy);
    }

    private List<Line> drawLine(int height, Participant participant, LineStrategy lineStrategy) {
        return IntStream.range(0, height)
                .mapToObj(h -> new Line(participant, lineStrategy))
                .collect(Collectors.toList());
    }

    public int getHeight() {
        return height.height();
    }

    public Participant getParticipant() {
        return participant;
    }

    public List<Line> getLines() {
        return lines;
    }

    public int getLineSize(){
        return lines.size();
    }
}
