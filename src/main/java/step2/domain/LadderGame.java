package step2.domain;

import java.util.List;

public class LadderGame {
    private final Names names;
    private final Lines lines;

    public LadderGame(List<String> names, int height) {
        this.names = new Names(names);
        this.lines = Lines.of(names.size(), height);
    }
}