package ladder.controller.dto;

import ladder.domain.Height;
import ladder.domain.Names;
import ladder.domain.Results;

import java.util.List;

public class LadderRequest {

    private final Names names;
    private final Results results;
    private final Height ladderHeight;

    public LadderRequest(List<String> names, List<String> results, int ladderHeight) {
        this.names = new Names(names);
        this.results = new Results(results);
        this.ladderHeight = new Height(ladderHeight);
    }

    public Names names() {
        return this.names;
    }

    public Results results() {
        return this.results;
    }

    public int ladderHeight() {
        return this.ladderHeight.height();
    }

}
