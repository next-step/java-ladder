package nextstep.ladder.domain;

import java.util.List;

public class LadderGame {

    private final List<String> names;

    private final Ladder ladder;

    public LadderGame(List<String> names, Ladder ladder) {
        this.names = names;
        this.ladder = ladder;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        names.forEach(name -> stringBuilder.append(String.format("%6s", name)));
        return stringBuilder.append("\n").append(ladder.toString()).toString();
    }
}
