package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderRows {

    private List<LadderRow> ladderRows;

    public LadderRows(Users users, LadderHeight height) {
        this.ladderRows = Collections.unmodifiableList(IntStream.range(0, height.getHeight())
                .boxed()
                .map(index -> new LadderRow(users.size()))
                .collect(Collectors.toList()));
    }

    public List<LadderRow> getLadderRows() {
        return this.ladderRows;
    }
}
