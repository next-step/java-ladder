package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<String> people;
    private final List<String> playResults;
    private final List<Line> lines;

    public Ladder(final List<String> people, final List<Line> lines, final List<String> playResults) {
        this.people = people;
        this.lines = lines;
        this.playResults = playResults;
    }

    public LadderResults play() {
        List<LadderResult> list = new ArrayList<>();
        int bound = people.size();
        for (int i = 0; i < bound; i++) {
            LadderResult move = move(i);
            list.add(move);
        }
        return new LadderResults(list);
    }

    public LadderResult move(final int position) {
        int result = position;
        for (Line line : lines) {
            result = line.move(result);
        }
        return new LadderResult(people.get(position), playResults.get(result));
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
