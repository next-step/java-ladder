package nextstep.step2.domain;

import nextstep.step2.generator.RandomBooleanGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final Participants participants;
    private final List<Line> lines;

    public Ladder(Participants participants, int ladderHeight) {
        this.participants = participants;
        this.lines = createLines(ladderHeight);
    }

    public Ladder(Participants participants, List<Line> lines) {
        this.participants = participants;
        this.lines = lines;
    }

    private List<Line> createLines(int height) {
        return IntStream.range(0, height)
                .mapToObj(i -> createLine(participants.count()))
                .collect(Collectors.toList());
    }

    private Line createLine(int count) {
        return new Line(count, new RandomBooleanGenerator());
    }

    public List<Line> lines() {
        return lines;
    }

    public int size() {
        return this.lines.size();
    }

    public int move(String name) {
        var position = participants.position(name);

        for (Line line : lines) {
            position = line.move(position);
        }

        return position;
    }
}
