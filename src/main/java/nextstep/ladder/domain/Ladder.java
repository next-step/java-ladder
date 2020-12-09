package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private List<LadderRow> ladderRows;

    public Ladder(Users users, LadderHeight height) {
        this.ladderRows = Collections.unmodifiableList(IntStream.range(0, height.getValue())
                .boxed()
                .map(index -> new LadderRow(users.size()))
                .collect(Collectors.toList()));
    }

    public List<LadderRow> getLadderRows() {
        return this.ladderRows;
    }
}
