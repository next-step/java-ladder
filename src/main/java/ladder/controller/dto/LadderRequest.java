package ladder.controller.dto;

import ladder.domain.Height;
import ladder.domain.Names;

import java.util.List;

public class LadderRequest {

    private final Names names;
    private final Height ladderHeight;

    public LadderRequest(List<String> names, int ladderHeight) {
        this.names = new Names(names);
        this.ladderHeight = new Height(ladderHeight);
    }

    public Names names() {
        return this.names;
    }

    public int ladderHeight() {
        return this.ladderHeight.height();
    }

}
