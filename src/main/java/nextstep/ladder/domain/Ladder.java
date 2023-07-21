package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    public final People people;
    private PointFactory pointFactory = new DefaultPointFactory();

    public final List<Line> ladder;

    public Ladder(int ladderHeight, People people) {
        checkLadderHeight(ladderHeight);

        this.people = people;

        this.ladder = createLine(ladderHeight);
    }

    @Override
    public String toString() {
        return people.toString() + "\n" + linesToString();
    }

    private String linesToString() {
        return String.join("\n", ladder.stream()
                .map(Line::toString)
                .collect(Collectors.toList()));
    }

    private List<Line> createLine(int ladderHeight) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < ladderHeight; i++) {
            ladder.add(new Line(people.people.size(), pointFactory));
        }

        return lines;
    }

    private void checkLadderHeight(int ladderHeight) {
        if (ladderHeight <= 0) {
            throw new IllegalArgumentException("높이는 1 이상으로 설정 하세요");
        }
    }
}
