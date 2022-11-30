package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<String> people;
    private final List<Line> lines;

    public Ladder(final List<String> people, final List<Line> lines) {
        this.people = people;
        this.lines = lines;
    }

    public List<LadderResult> play() {
        List<LadderResult> list = new ArrayList<>();
        int bound = people.size();
        for (int i = 0; i < bound; i++) {
            LadderResult move = move(i);
            list.add(move);
        }
        return list;
    }

    public LadderResult move(final int position) {
        int result = position;
        for (Line line : lines) {
            result = line.move(result);
        }
        return new LadderResult(people.get(position), result);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
