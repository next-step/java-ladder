package nextstep.ladder.controller.dto;

import nextstep.ladder.domain.Ladder;

public class GameInfo {

    private String[] names;
    private Ladder ladder;

    public GameInfo(String[] names, Ladder ladder) {
        this.names = names;
        this.ladder = ladder;
    }

    public String[] names() {
        return this.names;
    }

    public Ladder ladder() {
        return this.ladder;
    }
}
